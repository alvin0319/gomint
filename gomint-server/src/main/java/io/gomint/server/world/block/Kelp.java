/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockKelp;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:kelp")
public class Kelp extends Block implements BlockKelp {

    @Override
    public float blastResistance() {
        return 0.1f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.KELP;
    }

}
