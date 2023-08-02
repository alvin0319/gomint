package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockRedstoneTorchActive;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:redstone_torch")
public class RedstoneTorchActive extends Block implements BlockRedstoneTorchActive {

    @Override
    public String blockId() {
        return "minecraft:redstone_torch";
    }

    @Override
    public boolean transparent() {
        return true;
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
        return BlockType.REDSTONE_TORCH_ACTIVE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
