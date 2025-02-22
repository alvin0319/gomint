package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:monster_egg")
public class ItemMonsterEgg extends ItemStack<io.gomint.inventory.item.ItemMonsterEgg> implements io.gomint.inventory.item.ItemMonsterEgg {

    @Override
    public ItemType itemType() {
        return ItemType.MONSTER_EGG;
    }

}
