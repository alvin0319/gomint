package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:emptymap")
public class ItemMap extends ItemStack<io.gomint.inventory.item.ItemMap> implements io.gomint.inventory.item.ItemMap {


    @Override
    public ItemType itemType() {
        return ItemType.MAP;
    }

}
