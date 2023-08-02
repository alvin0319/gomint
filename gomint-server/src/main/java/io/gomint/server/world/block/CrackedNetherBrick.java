package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockType;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:cracked_nether_bricks")
public class CrackedNetherBrick extends Block {

    @Override
    public String blockId() {
        return "minecraft:cracked_nether_bricks";
    }

    @Override
    public float blastResistance() {
        return 30.0f;
    }

    @Override
    public long breakTime() {
        return 3000;
    }

    @Override
    public BlockType blockType() {
        return BlockType.CRACKED_NETHER_BRICK;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }
}
