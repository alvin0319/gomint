package io.gomint.server.world.block;

import io.gomint.server.entity.EntityLiving;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockFlowingWater;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:flowing_water")
public class FlowingWater extends Liquid<BlockFlowingWater> implements BlockFlowingWater {

    @Override
    public long breakTime() {
        return 150000;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 500.0f;
    }

    @Override
    public int getTickDiff() {
        return 250;
    }

    @Override
    public void onEntityStanding(EntityLiving<?> entityLiving) {
        if (entityLiving.burning()) {
            entityLiving.extinguish();
        }
    }

    @Override
    public BlockType blockType() {
        return BlockType.FLOWING_WATER;
    }

    @Override
    public boolean isFlowing() {
        return true;
    }

}
