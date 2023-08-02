package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockSeaLantern;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:seaLantern")
public class SeaLantern extends Block implements BlockSeaLantern {

    @Override
    public String blockId() {
        return "minecraft:seaLantern";
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
        return BlockType.SEA_LANTERN;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
