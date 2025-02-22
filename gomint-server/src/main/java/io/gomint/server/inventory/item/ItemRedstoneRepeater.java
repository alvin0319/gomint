package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:repeater")
public class ItemRedstoneRepeater extends ItemStack<io.gomint.inventory.item.ItemRedstoneRepeater> implements io.gomint.inventory.item.ItemRedstoneRepeater {


    @Override
    public ItemType itemType() {
        return ItemType.REDSTONE_REPEATER;
    }

}
