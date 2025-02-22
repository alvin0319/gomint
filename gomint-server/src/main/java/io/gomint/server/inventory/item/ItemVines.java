package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:vine")
public class ItemVines extends ItemStack<io.gomint.inventory.item.ItemVines> implements io.gomint.inventory.item.ItemVines {

    @Override
    public ItemType itemType() {
        return ItemType.VINES;
    }

}
