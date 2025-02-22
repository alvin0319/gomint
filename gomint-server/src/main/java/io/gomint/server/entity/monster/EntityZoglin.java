package io.gomint.server.entity.monster;

import io.gomint.server.entity.Attribute;
import io.gomint.server.entity.EntityAgeable;
import io.gomint.server.entity.EntityTags;
import io.gomint.server.entity.EntityType;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.WorldAdapter;
import java.util.Set;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:zoglin")
public class EntityZoglin extends EntityAgeable<io.gomint.entity.monster.EntityZoglin> implements io.gomint.entity.monster.EntityZoglin {

    /**
     * Constructs a new EntityLiving
     *
     * @param world The world in which this entity is in
     */
    public EntityZoglin(WorldAdapter world) {
        super(EntityType.ZOGLIN, world);
        this.initEntity();
    }


    public EntityZoglin() {
        super(EntityType.ZOGLIN, null);
        this.initEntity();
    }

    private void initEntity() {
        this.attribute(Attribute.HEALTH);
        this.health(40);
        this.maxHealth(40);
        if (this.baby()) {
            this.size(0.69825f, 0.7f);
        } else {
            this.size(1.3965f, 1.4f);
        }
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
