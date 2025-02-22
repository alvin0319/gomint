package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:ender_chest")
public class ItemEnderChest extends ItemStack<io.gomint.inventory.item.ItemEnderChest> implements io.gomint.inventory.item.ItemEnderChest {

    @Override
    public ItemType itemType() {
        return ItemType.ENDER_CHEST;
    }

}
