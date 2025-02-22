package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:stained_glass")
public class ItemStainedGlass extends ItemStack<io.gomint.inventory.item.ItemStainedGlass> implements io.gomint.inventory.item.ItemStainedGlass {

    @Override
    public ItemType itemType() {
        return ItemType.STAINED_GLASS;
    }

}
