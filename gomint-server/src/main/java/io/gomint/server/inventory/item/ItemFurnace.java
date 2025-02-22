package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:furnace")
public class ItemFurnace extends ItemStack<io.gomint.inventory.item.ItemFurnace> implements io.gomint.inventory.item.ItemFurnace {

    @Override
    public ItemType itemType() {
        return ItemType.FURNACE;
    }

}
