package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:smoker")
public class ItemSmoker extends ItemStack<io.gomint.inventory.item.ItemSmoker> implements io.gomint.inventory.item.ItemSmoker {

    @Override
    public ItemType itemType() {
        return ItemType.SMOKER;
    }

}
