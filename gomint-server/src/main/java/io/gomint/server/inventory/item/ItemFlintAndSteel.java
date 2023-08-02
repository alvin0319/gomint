/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.inventory.item.annotation.CanBeDamaged;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.Block;
import io.gomint.world.block.BlockFire;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@CanBeDamaged
@RegisterInfo(sId = "minecraft:flint_and_steel")
public class ItemFlintAndSteel extends ItemStack<io.gomint.inventory.item.ItemFlintAndSteel> implements io.gomint.inventory.item.ItemFlintAndSteel {

    @Override
    public ItemType itemType() {
        return ItemType.FLINT_AND_STEEL;
    }

    @Override
    public boolean interact(EntityPlayer entity, Facing face, Vector clickPosition, Block clickedBlock) {
        if (clickedBlock == null) {
            return false; // We clicked in air, ignore
        }

        clickedBlock.side(face).blockType(BlockFire.class);
        return true;
    }

    /**
     * Rather than decrease the amount of the item in the inventory, damage is applied.
     */
    @Override
    public io.gomint.inventory.item.ItemFlintAndSteel afterPlacement() {
        this.calculateUsageAndUpdate(1);
        return this;
    }

}
