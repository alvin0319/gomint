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
@RegisterInfo(sId = "minecraft:ancient_debris")
public class ItemAncientDebris extends ItemStack<io.gomint.inventory.item.ItemAncientDebris> implements io.gomint.inventory.item.ItemAncientDebris {

    @Override
    public ItemType itemType() {
        return ItemType.ANCIENT_DEBRIS;
    }

}
