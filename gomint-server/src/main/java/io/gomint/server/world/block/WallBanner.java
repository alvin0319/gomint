package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:wall_banner")
public class WallBanner extends Banner {

    @Override
    public String blockId() {
        return "minecraft:wall_banner";
    }

    @Override
    public BlockType blockType() {
        return BlockType.WALL_BANNER;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
