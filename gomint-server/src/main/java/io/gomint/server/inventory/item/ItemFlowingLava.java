package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:flowing_lava")
public class ItemFlowingLava extends ItemStack<io.gomint.inventory.item.ItemFlowingLava> implements io.gomint.inventory.item.ItemFlowingLava {

    @Override
    public ItemType itemType() {
        return ItemType.FLOWING_LAVA;
    }

}
