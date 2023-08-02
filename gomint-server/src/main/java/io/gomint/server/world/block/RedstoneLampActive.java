package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockRedstoneLampActive;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:lit_redstone_lamp")
public class RedstoneLampActive extends Block implements BlockRedstoneLampActive {

    @Override
    public String blockId() {
        return "minecraft:lit_redstone_lamp";
    }

    @Override
    public long breakTime() {
        return 450;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 1.5f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.REDSTONE_LAMP_ACTIVE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
