package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockRedMushroomBlock;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:red_mushroom_block")
public class RedMushroomBlock extends Block implements BlockRedMushroomBlock {

    @Override
    public String blockId() {
        return "minecraft:red_mushroom_block";
    }

    @Override
    public float blastResistance() {
        return 1.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.RED_MUSHROOM_BLOCK;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
