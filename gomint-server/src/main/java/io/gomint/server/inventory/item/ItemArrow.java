package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:arrow")
public class ItemArrow extends ItemStack<io.gomint.inventory.item.ItemArrow> implements io.gomint.inventory.item.ItemArrow {

    @Override
    public ItemType itemType() {
        return ItemType.ARROW;
    }

}
