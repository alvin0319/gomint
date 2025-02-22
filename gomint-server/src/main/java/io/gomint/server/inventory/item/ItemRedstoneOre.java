package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:redstone_ore")
public class ItemRedstoneOre extends ItemStack<io.gomint.inventory.item.ItemRedstoneOre> implements io.gomint.inventory.item.ItemRedstoneOre {

    @Override
    public ItemType itemType() {
        return ItemType.REDSTONE_ORE;
    }

}
