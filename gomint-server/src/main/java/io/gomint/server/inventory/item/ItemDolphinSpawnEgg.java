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
@RegisterInfo(sId = "minecraft:dolphin_spawn_egg")
public class ItemDolphinSpawnEgg extends ItemStack<io.gomint.inventory.item.ItemDolphinSpawnEgg> implements io.gomint.inventory.item.ItemDolphinSpawnEgg {

    @Override
    public ItemType itemType() {
        return ItemType.DOLPHIN_SPAWN_EGG;
    }

}
