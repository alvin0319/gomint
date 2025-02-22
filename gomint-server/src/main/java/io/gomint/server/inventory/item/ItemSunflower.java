package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:double_plant")
public class ItemSunflower extends ItemStack<io.gomint.inventory.item.ItemSunflower> implements io.gomint.inventory.item.ItemSunflower {

    @Override
    public ItemType itemType() {
        return ItemType.SUNFLOWER;
    }

}
