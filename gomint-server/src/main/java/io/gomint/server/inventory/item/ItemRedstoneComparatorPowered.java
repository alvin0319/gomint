package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:powered_comparator")
public class ItemRedstoneComparatorPowered extends ItemStack<ItemRedstoneComparatorPowered> {

    @Override
    public ItemType itemType() {
        return ItemType.REDSTONE_COMPARATOR_POWERED;
    }

}
