package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;
import java.time.Duration;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:birch_stairs")
public class ItemBirchWoodStairs extends ItemStack<io.gomint.inventory.item.ItemBirchWoodStairs> implements io.gomint.inventory.item.ItemBirchWoodStairs {

    @Override
    public ItemType itemType() {
        return ItemType.BIRCH_WOOD_STAIRS;
    }

    @Override
    public Duration burnTime() {
        return Duration.ofMillis(15000);
    }


}
