package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:feather")
public class ItemFeather extends ItemStack<io.gomint.inventory.item.ItemFeather> implements io.gomint.inventory.item.ItemFeather {


    @Override
    public ItemType itemType() {
        return ItemType.FEATHER;
    }

}
