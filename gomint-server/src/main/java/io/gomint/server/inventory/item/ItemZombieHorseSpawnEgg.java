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
@RegisterInfo(sId = "minecraft:zombie_horse_spawn_egg")
public class ItemZombieHorseSpawnEgg extends ItemStack<io.gomint.inventory.item.ItemZombieHorseSpawnEgg> implements io.gomint.inventory.item.ItemZombieHorseSpawnEgg {

    @Override
    public ItemType itemType() {
        return ItemType.ZOMBIE_HORSE_SPAWN_EGG;
    }

}
