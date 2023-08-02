package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockMelon;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:melon_block")
public class Melon extends Block implements BlockMelon {

    @Override
    public String blockId() {
        return "minecraft:melon_block";
    }

    @Override
    public long breakTime() {
        return 1500;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 5.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.MELON;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
