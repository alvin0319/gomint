package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:standing_banner")
public class StandingBanner extends Banner {

    @Override
    public String blockId() {
        return "minecraft:standing_banner";
    }

    @Override
    public BlockType blockType() {
        return BlockType.STANDING_BANNER;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
