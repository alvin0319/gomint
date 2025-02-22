package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.entity.tileentity.DropperTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockDropper;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:dropper")
public class Dropper extends Block implements BlockDropper {

    @Override
    public String blockId() {
        return "minecraft:dropper";
    }

    @Override
    public long breakTime() {
        return 5250;
    }

    @Override
    public float blastResistance() {
        return 17.5f;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    public BlockType blockType() {
        return BlockType.DROPPER;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    TileEntity createTileEntity(NBTTagCompound compound) {
        super.createTileEntity(compound);
        return this.tileEntities.construct(DropperTileEntity.class, compound, this, this.items);
    }

}
