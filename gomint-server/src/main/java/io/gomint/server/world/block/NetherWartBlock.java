/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockNetherWartBlock;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:nether_wart_block")
public class NetherWartBlock extends Block implements BlockNetherWartBlock {

    @Override
    public String blockId() {
        return "minecraft:nether_wart_block";
    }

    @Override
    public float blastResistance() {
        return 5f;
    }

    @Override
    public long breakTime() {
        return 1500;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public BlockType blockType() {
        return BlockType.NETHER_WART_BLOCK;
    }

}
