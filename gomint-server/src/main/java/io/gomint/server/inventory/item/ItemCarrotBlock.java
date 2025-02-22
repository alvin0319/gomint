package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:carrots")
public class ItemCarrotBlock extends ItemStack<io.gomint.inventory.item.ItemCarrotBlock> implements io.gomint.inventory.item.ItemCarrotBlock {

    @Override
    public ItemType itemType() {
        return ItemType.CARROTS;
    }

}
