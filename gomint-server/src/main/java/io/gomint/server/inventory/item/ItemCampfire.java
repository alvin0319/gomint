/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:campfire")
public class ItemCampfire extends ItemStack<io.gomint.inventory.item.ItemCampfire> implements io.gomint.inventory.item.ItemCampfire {

    @Override
    public byte maximumAmount() {
        return 1;
    }

    @Override
    public ItemType itemType() {
        return ItemType.CAMPFIRE;
    }

}
