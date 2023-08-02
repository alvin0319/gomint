package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:air")
public class ItemAir extends ItemStack<io.gomint.inventory.item.ItemAir> implements io.gomint.inventory.item.ItemAir {

    @Override
    public ItemType itemType() {
        return ItemType.AIR;
    }

}
