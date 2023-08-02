package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockChiseledPolishedBlackStone;
import io.gomint.world.block.BlockType;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:chiseled_polished_blackstone")
public class ChiseledPolishedBlackStone extends Block implements BlockChiseledPolishedBlackStone {

    @Override
    public String blockId() {
        return "minecraft:chiseled_polished_blackstone";
    }

    @Override
    public long breakTime() {
        return 3000;
    }

    @Override
    public float blastResistance() {
        return 10.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.CHISELED_POLISHED_BLACKSTONE;
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
