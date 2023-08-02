/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:acacia_standing_sign")
public class ItemAcaciaStandingSign extends ItemStack<io.gomint.inventory.item.ItemAcaciaStandingSign> implements io.gomint.inventory.item.ItemAcaciaStandingSign {

    @Override
    public ItemType itemType() {
        return ItemType.ACACIA_STANDING_SIGN;
    }

}
