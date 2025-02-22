package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:cactus")
public class ItemCactus extends ItemStack<io.gomint.inventory.item.ItemCactus> implements io.gomint.inventory.item.ItemCactus {

    @Override
    public ItemType itemType() {
        return ItemType.CACTUS;
    }

}
