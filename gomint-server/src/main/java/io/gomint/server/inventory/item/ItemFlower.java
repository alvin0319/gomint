package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:red_flower", def = true)
@RegisterInfo(sId = "minecraft:wither_rose")
public class ItemFlower extends ItemStack<io.gomint.inventory.item.ItemFlower> implements io.gomint.inventory.item.ItemFlower {

    @Override
    public ItemType itemType() {
        return ItemType.FLOWER;
    }

}
