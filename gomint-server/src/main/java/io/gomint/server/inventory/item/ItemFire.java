package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:fire")
public class ItemFire extends ItemStack<io.gomint.inventory.item.ItemFire> implements io.gomint.inventory.item.ItemFire {

    @Override
    public ItemType itemType() {
        return ItemType.FIRE;
    }

}
