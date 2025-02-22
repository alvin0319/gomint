package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:powered_repeater")
public class ItemRedstoneRepeaterActive extends ItemStack<ItemRedstoneRepeaterActive> {

    @Override
    public ItemType itemType() {
        return ItemType.REDSTONE_REPEATER_ACTIVE;
    }

}
