/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockBambooSapling;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:bamboo_sapling")
public class BambooSapling extends Block implements BlockBambooSapling {

    @Override
    public String blockId() {
        return "minecraft:bamboo_sapling";
    }

    @Override
    public long breakTime() {
        return 0;
    }

    @Override
    public float blastResistance() {
        return 0;
    }

    @Override
    public BlockType blockType() {
        return BlockType.BAMBOO;
    }

}
