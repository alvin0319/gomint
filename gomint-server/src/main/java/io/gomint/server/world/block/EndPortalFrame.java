package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockEndPortalFrame;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:end_portal_frame")
public class EndPortalFrame extends Block implements BlockEndPortalFrame {

    @Override
    public String blockId() {
        return "minecraft:end_portal_frame";
    }

    @Override
    public long breakTime() {
        return -1;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 1.8E7f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.END_PORTAL_FRAME;
    }

}
