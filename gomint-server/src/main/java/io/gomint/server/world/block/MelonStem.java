package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockMelonStem;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:melon_stem")
public class MelonStem extends Growable implements BlockMelonStem {

    @Override
    public String blockId() {
        return "minecraft:melon_stem";
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
        return BlockType.MELON_STEM;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
