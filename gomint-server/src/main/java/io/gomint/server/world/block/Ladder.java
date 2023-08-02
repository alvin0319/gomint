package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.entity.Entity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.server.world.block.state.BlockfaceBlockState;
import io.gomint.world.block.BlockLadder;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:ladder")
public class Ladder extends Block implements BlockLadder {

    private static final BlockfaceBlockState ATTACHED = new BlockfaceBlockState(() -> new String[]{"facing_direction"});

    @Override
    public String blockId() {
        return "minecraft:ladder";
    }

    @Override
    public long breakTime() {
        return 600;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public boolean solid() {
        return false;
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    @Override
    public void stepOn(Entity<?> entity) {
        // Reset fall distance
        entity.resetFallDistance();
    }

    @Override
    public float blastResistance() {
        return 2.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.LADDER;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.AXE;
    }

    @Override
    public BlockLadder attachSide(Facing attachSide) {
        ATTACHED.state(this, attachSide);
        return this;
    }

    @Override
    public Facing attachSide() {
        return ATTACHED.state(this);
    }

}
