package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:snow")
public class ItemSnow extends ItemStack<io.gomint.inventory.item.ItemSnow> implements io.gomint.inventory.item.ItemSnow {

    @Override
    public ItemType itemType() {
        return ItemType.SNOW;
    }

}
