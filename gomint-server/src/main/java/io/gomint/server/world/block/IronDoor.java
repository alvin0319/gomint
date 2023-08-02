package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockIronDoor;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:iron_door")
public class IronDoor extends Door<BlockIronDoor> implements BlockIronDoor {

    @Override
    public long breakTime() {
        return 7500;
    }

    @Override
    public float blastResistance() {
        return 25.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.IRON_DOOR;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public void afterPlacement() {
        Block above = this.side(Facing.UP);
        IronDoor aDoor = above.blockType(IronDoor.class);
        aDoor.direction(this.direction());
        aDoor.top(true);

        super.afterPlacement();
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

}
