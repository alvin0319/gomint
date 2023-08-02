package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockFlowerPot;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:flower_pot")
public class FlowerPot extends Block implements BlockFlowerPot {

    @Override
    public String blockId() {
        return "minecraft:flower_pot";
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
    public long breakTime() {
        return 0;
    }

    @Override
    public BlockType blockType() {
        return BlockType.FLOWER_POT;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
