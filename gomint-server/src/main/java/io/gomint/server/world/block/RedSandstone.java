package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockRedSandstone;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:red_sandstone")
public class RedSandstone extends Block implements BlockRedSandstone {

    @Override
    public String blockId() {
        return "minecraft:red_sandstone";
    }

    @Override
    public long breakTime() {
        return 1200;
    }

    @Override
    public float blastResistance() {
        return 4.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.RED_SANDSTONE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.SHOVEL;
    }

}
