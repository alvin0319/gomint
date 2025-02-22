package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:obsidian")
public class ItemObsidian extends ItemStack<io.gomint.inventory.item.ItemObsidian> implements io.gomint.inventory.item.ItemObsidian {

    @Override
    public ItemType itemType() {
        return ItemType.OBSIDIAN;
    }

}
