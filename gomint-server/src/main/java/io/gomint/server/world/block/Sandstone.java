package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockSandstone;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:sandstone")
public class Sandstone extends Block implements BlockSandstone {

    @Override
    public String blockId() {
        return "minecraft:sandstone";
    }

    @Override
    public long breakTime() {
        return 1200;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    public float blastResistance() {
        return 4.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.SANDSTONE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return false;
    }

}
