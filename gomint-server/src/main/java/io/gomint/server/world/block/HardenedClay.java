package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockHardenedClay;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:hardened_clay")
public class HardenedClay extends Block implements BlockHardenedClay {

    @Override
    public String blockId() {
        return "minecraft:hardened_clay";
    }

    @Override
    public long breakTime() {
        return 1875;
    }

    @Override
    public float blastResistance() {
        return 7.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.HARDENED_CLAY;
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
