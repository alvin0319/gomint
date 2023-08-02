/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.Entity;
import io.gomint.server.entity.tileentity.ShulkerBoxTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.BlockUndyedShulkerBox;
import io.gomint.world.block.data.Facing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:undyed_shulker_box")
public class UndyedShulkerBox extends Block implements BlockUndyedShulkerBox {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShulkerBox.class);

    @Override
    public String blockId() {
        return "minecraft:undyed_shulker_box";
    }

    @Override
    public float blastResistance() {
        return 30.0f;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public long breakTime() {
        return 9000;
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    public boolean interact(Entity<?> entity, Facing face, Vector facePos, ItemStack<?> item) {
        ShulkerBoxTileEntity tileEntity = this.tileEntity();
        if (tileEntity != null) {
            tileEntity.interact(entity, face, facePos, item);
        } else {
            LOGGER.warn("ShulkerBox @ {} has no tile entity. Generating new tile entity", this.location);
            tileEntity = (ShulkerBoxTileEntity) this.createTileEntity(new NBTTagCompound(""));
            this.tileEntity(tileEntity);
            this.world.storeTileEntity(this.location.toBlockPosition(), tileEntity);
            tileEntity.interact(entity, face, facePos, item);
        }

        return true;
    }

    @Override
    TileEntity createTileEntity(NBTTagCompound compound) {
        super.createTileEntity(compound);
        return this.tileEntities.construct(ShulkerBoxTileEntity.class, compound, this, this.items);
    }

    @Override
    public BlockType blockType() {
        return BlockType.UNDYED_SHULKER_BOX;
    }

}
