package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:name_tag")
public class ItemNameTag extends ItemStack<io.gomint.inventory.item.ItemNameTag> implements io.gomint.inventory.item.ItemNameTag {


    @Override
    public ItemType itemType() {
        return ItemType.NAME_TAG;
    }

}
