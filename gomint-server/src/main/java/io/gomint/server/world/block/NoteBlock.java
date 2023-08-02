package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.Entity;
import io.gomint.server.entity.tileentity.NoteblockTileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockNoteblock;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:noteblock")
public class NoteBlock extends Block implements BlockNoteblock {

    @Override
    public String blockId() {
        return "minecraft:noteblock";
    }

    @Override
    public long breakTime() {
        return 1200;
    }

    @Override
    public boolean interact(Entity<?> entity, Facing face, Vector facePos, ItemStack<?> item) {
        NoteblockTileEntity tileEntity = tileEntity();
        if (tileEntity != null) {
            tileEntity.interact(entity, face, facePos, item);
        }

        return true;
    }

    @Override
    public BlockNoteblock playNote() {
        NoteblockTileEntity tileEntity = tileEntity();
        if (tileEntity != null) {
            tileEntity.playSound();
        }

        return this;
    }

    @Override
    public float blastResistance() {
        return 4.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.NOTE_BLOCK;
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
