package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:netherrack")
public class ItemNetherrack extends ItemStack<io.gomint.inventory.item.ItemNetherrack> implements io.gomint.inventory.item.ItemNetherrack {

    @Override
    public ItemType itemType() {
        return ItemType.NETHERRACK;
    }

}
