package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.Entity;
import io.gomint.server.entity.tileentity.EnchantTableTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockEnchantmentTable;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:enchanting_table")
public class EnchantmentTable extends Block implements BlockEnchantmentTable {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnchantmentTable.class);

    @Override
    public String blockId() {
        return "minecraft:enchanting_table";
    }

    @Override
    public long breakTime() {
        return 7500;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 6000.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.ENCHANTMENT_TABLE;
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
        return this.tileEntities.construct(EnchantTableTileEntity.class, compound, this, this.items);
    }

    @Override
    public boolean interact(Entity<?> entity, Facing face, Vector facePos, ItemStack<?> item) {
        EnchantTableTileEntity tileEntity = this.tileEntity();
        tileEntity.interact(entity, face, facePos, item);
        return true;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

}
