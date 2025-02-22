package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:sticky_piston")
public class ItemStickyPiston extends ItemStack<io.gomint.inventory.item.ItemStickyPiston> implements io.gomint.inventory.item.ItemStickyPiston {

    @Override
    public ItemType itemType() {
        return ItemType.STICKY_PISTON;
    }

}
