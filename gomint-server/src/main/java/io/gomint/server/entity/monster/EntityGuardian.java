package io.gomint.server.entity.monster;

import io.gomint.server.entity.Attribute;
import io.gomint.server.entity.EntityLiving;
import io.gomint.server.entity.EntityTags;
import io.gomint.server.entity.EntityType;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.WorldAdapter;
import java.util.Set;

@RegisterInfo(sId = "minecraft:guardian")
public class EntityGuardian extends EntityLiving<io.gomint.entity.monster.EntityGuardian> implements io.gomint.entity.monster.EntityGuardian {

    /**
     * Constructs a new EntityLiving
     *
     * @param world The world in which this entity is in
     */
    public EntityGuardian(WorldAdapter world) {
        super(EntityType.GUARDIAN, world);
        this.initEntity();
    }

    /**
     * Create new entity guardian for API
     */
    public EntityGuardian() {
        super(EntityType.GUARDIAN, null);
        this.initEntity();
    }

    private void initEntity() {
        this.size(0.85f, 0.85f);
        this.attribute(Attribute.HEALTH);
        this.maxHealth(30);
        this.health(30);
    }

    @Override
    public void update(long currentTimeMS, float dT) {
        super.update(currentTimeMS, dT);
    }

    @Override
    public Set<String> tags() {
        return EntityTags.HOSTILE_MOB;
    }

}
