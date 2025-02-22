package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:quartz_block")
public class ItemBlockOfQuartz extends ItemStack<io.gomint.inventory.item.ItemBlockOfQuartz> implements io.gomint.inventory.item.ItemBlockOfQuartz {

    @Override
    public ItemType itemType() {
        return ItemType.BLOCK_OF_QUARTZ;
    }

}
