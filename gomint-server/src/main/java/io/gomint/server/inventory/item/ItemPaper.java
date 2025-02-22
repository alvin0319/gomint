package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:paper")
public class ItemPaper extends ItemStack<io.gomint.inventory.item.ItemPaper> implements io.gomint.inventory.item.ItemPaper {


    @Override
    public ItemType itemType() {
        return ItemType.PAPER;
    }

}
