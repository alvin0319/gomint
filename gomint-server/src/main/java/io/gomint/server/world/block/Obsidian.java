package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemDiamondPickaxe;
import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockObsidian;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:obsidian")
public class Obsidian extends Block implements BlockObsidian {

    @Override
    public String blockId() {
        return "minecraft:obsidian";
    }

    @Override
    public long breakTime() {
        return 75000;
    }

    @Override
    public float blastResistance() {
        return 6000.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.OBSIDIAN;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return new Class[]{
            ItemDiamondPickaxe.class
        };
    }

}
