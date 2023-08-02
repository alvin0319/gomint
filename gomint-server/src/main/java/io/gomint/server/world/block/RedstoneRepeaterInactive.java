package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockRedstoneRepeaterInactive;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:unpowered_repeater")
public class RedstoneRepeaterInactive extends Block implements BlockRedstoneRepeaterInactive {

    @Override
    public String blockId() {
        return "minecraft:unpowered_repeater";
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
        return BlockType.REDSTONE_REPEATER_INACTIVE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
