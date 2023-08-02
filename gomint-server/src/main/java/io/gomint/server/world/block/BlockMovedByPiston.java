package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockBlockMovedByPiston;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:movingBlock")
public class BlockMovedByPiston extends Block implements BlockBlockMovedByPiston {

    @Override
    public String blockId() {
        return "minecraft:movingBlock";
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 0.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.BLOCK_MOVED_BY_PISTON;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
