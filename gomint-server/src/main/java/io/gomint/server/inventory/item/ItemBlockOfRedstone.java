package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:redstone_block")
public class ItemBlockOfRedstone extends ItemStack<io.gomint.inventory.item.ItemBlockOfRedstone> implements io.gomint.inventory.item.ItemBlockOfRedstone {

    @Override
    public ItemType itemType() {
        return ItemType.BLOCK_OF_REDSTONE;
    }

}
