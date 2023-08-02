package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockClay;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:clay")
public class Clay extends Block implements BlockClay {

    @Override
    public String blockId() {
        return "minecraft:clay";
    }

    @Override
    public long breakTime() {
        return 900;
    }

    @Override
    public float blastResistance() {
        return 3.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.CLAY;
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
