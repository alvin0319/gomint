package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:minecart")
public class ItemMinecart extends ItemStack<io.gomint.inventory.item.ItemMinecart> implements io.gomint.inventory.item.ItemMinecart {


    @Override
    public ItemType itemType() {
        return ItemType.MINECART;
    }

}
