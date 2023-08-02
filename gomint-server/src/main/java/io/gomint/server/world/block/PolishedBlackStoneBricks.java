package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockPolishedBlackStoneBricks;
import io.gomint.world.block.BlockType;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:polished_blackstone_bricks")
public class PolishedBlackStoneBricks extends Block implements BlockPolishedBlackStoneBricks {

    @Override
    public String blockId() {
        return "minecraft:polished_blackstone_bricks";
    }

    @Override
    public long breakTime() {
        return 2300;
    }

    @Override
    public float blastResistance() {
        return 10.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.POLISHED_BLACKSTONE_BRICKS;
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
