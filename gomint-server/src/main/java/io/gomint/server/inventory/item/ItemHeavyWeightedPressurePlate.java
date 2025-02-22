package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:heavy_weighted_pressure_plate")
public class ItemHeavyWeightedPressurePlate extends ItemStack<io.gomint.inventory.item.ItemHeavyWeightedPressurePlate> implements io.gomint.inventory.item.ItemHeavyWeightedPressurePlate {

    @Override
    public ItemType itemType() {
        return ItemType.HEAVY_WEIGHTED_PRESSURE_PLATE;
    }

}
