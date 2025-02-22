package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:leather")
public class ItemLeather extends ItemStack<io.gomint.inventory.item.ItemLeather> implements io.gomint.inventory.item.ItemLeather {


    @Override
    public ItemType itemType() {
        return ItemType.LEATHER;
    }

}
