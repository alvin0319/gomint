/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.entity.animal;

import io.gomint.entity.Entity;
import io.gomint.event.entity.EntityDamageByEntityEvent;
import io.gomint.event.entity.EntityDamageEvent;
import io.gomint.inventory.item.ItemCookedMutton;
import io.gomint.inventory.item.ItemRawMutton;
import io.gomint.inventory.item.ItemStack;
import io.gomint.inventory.item.ItemWool;
import io.gomint.server.entity.Attribute;
import io.gomint.server.entity.EntityType;
import io.gomint.server.entity.ai.AIAfterHitMovement;
import io.gomint.server.entity.ai.AIPassiveIdleMovement;
import io.gomint.server.entity.pathfinding.PathfindingEngine;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.WorldAdapter;
import io.gomint.world.block.data.BlockColor;
import java.util.concurrent.ThreadLocalRandom;

@RegisterInfo(sId = "minecraft:sheep")
public class EntitySheep extends EntityAgeableAnimal<io.gomint.entity.animal.EntitySheep> implements io.gomint.entity.animal.EntitySheep {

    /**
     * Constructs a new EntityLiving
     *
     * @param world The world in which this entity is in
     */
    public EntitySheep(WorldAdapter world) {
        super(EntityType.SHEEP, world);
        this.initEntity();
    }

    /**
     * Create new entity sheep for API
     */
    public EntitySheep() {
        super(EntityType.SHEEP, null);
        this.initEntity();
    }

    private void initEntity() {
        this.attribute(Attribute.HEALTH);
        this.maxHealth(16);
        this.health(16);

        if (this.baby()) {
            this.size(0.45f, 0.65f);
        } else {
            this.size(0.9f, 1.3f);
        }
    }

    @Override
    public void update(long currentTimeMS, float dT) {
        super.update(currentTimeMS, dT);
    }

    @Override
    public boolean damage(EntityDamageEvent damageEvent) {
        // Run away from attacker
        if (damageEvent.damageSource() == EntityDamageEvent.DamageSource.ENTITY_ATTACK) {
            EntityDamageByEntityEvent edbee = (EntityDamageByEntityEvent) damageEvent;
            Entity<?> attacker = edbee.attacker();
            this.switchToAttackMovement(attacker);
        }

        return super.damage(damageEvent);
    }

    @Override
    protected void kill() {
        super.kill();

        // Babies don't drop
        if (this.baby()) {
            return;
        }

        // Drop items
        ItemWool wool = ItemWool.create(1);
        wool.color(BlockColor.WHITE); // TODO: Implement sheep colors

        this.world.dropItem(this.location(), wool);

        int amount = 1 + ThreadLocalRandom.current().nextInt(2);
        ItemStack<?> mutton;

        if (this.lastDamageSource == EntityDamageEvent.DamageSource.ON_FIRE) {
            mutton = ItemCookedMutton.create(amount);
        } else {
            mutton = ItemRawMutton.create(amount);
        }

        this.world.dropItem(this.location(), mutton);

        // Drop xp
        this.world.createExpOrb(this.location(), 1 + ThreadLocalRandom.current().nextInt(3));
    }

    private void switchToAttackMovement(Entity<?> attacker) {
        this.behaviour.getMachine().switchState(new AIAfterHitMovement(this.behaviour.getMachine(), this.world,
            attacker.direction(), new PathfindingEngine(this.getTransform())));
    }

    private void switchToIdleMovement() {
        this.behaviour.getMachine().switchState(new AIPassiveIdleMovement(this.behaviour.getMachine(), this.world, new PathfindingEngine(this.getTransform())));
    }

    @Override
    protected void setupAI() {
        // Kick of AI
        this.switchToIdleMovement();
    }

}
