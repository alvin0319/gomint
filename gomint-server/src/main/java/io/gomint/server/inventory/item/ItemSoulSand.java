package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:soul_sand")
public class ItemSoulSand extends ItemStack<io.gomint.inventory.item.ItemSoulSand> implements io.gomint.inventory.item.ItemSoulSand {

    @Override
    public ItemType itemType() {
        return ItemType.SOUL_SAND;
    }

}
