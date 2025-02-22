package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:flowing_water")
public class ItemFlowingWater extends ItemStack<io.gomint.inventory.item.ItemFlowingWater> implements io.gomint.inventory.item.ItemFlowingWater {

    @Override
    public ItemType itemType() {
        return ItemType.FLOWING_WATER;
    }

}
