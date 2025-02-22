package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:glass")
public class ItemGlass extends ItemStack<io.gomint.inventory.item.ItemGlass> implements io.gomint.inventory.item.ItemGlass {

    @Override
    public ItemType itemType() {
        return ItemType.GLASS;
    }

}
