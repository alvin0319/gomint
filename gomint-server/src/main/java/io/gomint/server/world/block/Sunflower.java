package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockSunflower;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:double_plant")
public class Sunflower extends Block implements BlockSunflower {

    @Override
    public boolean canPassThrough() {
        return true;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public long breakTime() {
        return 0;
    }

    @Override
    public boolean solid() {
        return false;
    }

    @Override
    public float blastResistance() {
        return 0.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.SUNFLOWER;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
