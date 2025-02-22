package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:iron_block")
public class ItemBlockOfIron extends ItemStack<io.gomint.inventory.item.ItemBlockOfIron> implements io.gomint.inventory.item.ItemBlockOfIron {

    @Override
    public ItemType itemType() {
        return ItemType.BLOCK_OF_IRON;
    }

}
