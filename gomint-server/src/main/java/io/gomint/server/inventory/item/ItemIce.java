package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:ice")
public class ItemIce extends ItemStack<io.gomint.inventory.item.ItemIce> implements io.gomint.inventory.item.ItemIce {

    @Override
    public ItemType itemType() {
        return ItemType.ICE;
    }

}
