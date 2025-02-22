package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:string")
public class ItemString extends ItemStack<io.gomint.inventory.item.ItemString> implements io.gomint.inventory.item.ItemString {


    @Override
    public ItemType itemType() {
        return ItemType.STRING;
    }

}
