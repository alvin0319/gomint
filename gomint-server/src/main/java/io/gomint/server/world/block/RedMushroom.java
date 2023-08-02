package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockRedMushroom;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:red_mushroom")
public class RedMushroom extends Block implements BlockRedMushroom {

    @Override
    public String blockId() {
        return "minecraft:red_mushroom";
    }

    @Override
    public float blastResistance() {
        return 0.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.RED_MUSHROOM;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
