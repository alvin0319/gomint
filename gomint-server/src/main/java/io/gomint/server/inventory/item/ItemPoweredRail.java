package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:golden_rail")
public class ItemPoweredRail extends ItemStack<io.gomint.inventory.item.ItemPoweredRail> implements io.gomint.inventory.item.ItemPoweredRail {

    @Override
    public ItemType itemType() {
        return ItemType.POWERED_RAIL;
    }

}
