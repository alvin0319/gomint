package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:carpet")
public class ItemCarpet extends ItemStack<io.gomint.inventory.item.ItemCarpet> implements io.gomint.inventory.item.ItemCarpet {

    @Override
    public ItemType itemType() {
        return ItemType.CARPET;
    }

}
