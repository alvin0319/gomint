/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.server.world.block.state.BlockColorBlockState;
import io.gomint.world.block.BlockConcretePowder;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.BlockColor;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:concretePowder")
public class ConcretePowder extends Block implements BlockConcretePowder {

    private static final BlockColorBlockState COLOR = new BlockColorBlockState(() -> new String[]{"color"});

    @Override
    public String blockId() {
        return "minecraft:concretePowder";
    }

    @Override
    public long breakTime() {
        return 750;
    }

    @Override
    public float blastResistance() {
        return 2.5f;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public BlockType blockType() {
        return BlockType.CONCRETE_POWDER;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    public BlockColor color() {
        return COLOR.state(this);
    }

    @Override
    public BlockConcretePowder color(BlockColor color) {
        COLOR.state(this, color);
        return this;
    }

}
