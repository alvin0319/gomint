package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockCrimsonRoots;
import io.gomint.world.block.BlockType;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:crimson_roots")
public class CrimsonRoots extends Block implements BlockCrimsonRoots {

    @Override
    public String blockId() {
        return "minecraft:crimson_roots";
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 0;
    }

    @Override
    public long breakTime() {
        return 0;
    }

    @Override
    public BlockType blockType() {
        return BlockType.CRIMSON_ROOTS;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }
}
