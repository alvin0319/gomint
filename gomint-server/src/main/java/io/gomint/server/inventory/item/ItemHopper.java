package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:hopper")
public class ItemHopper extends ItemStack<io.gomint.inventory.item.ItemHopper> implements io.gomint.inventory.item.ItemHopper {

    @Override
    public ItemType itemType() {
        return ItemType.HOPPER;
    }

}
