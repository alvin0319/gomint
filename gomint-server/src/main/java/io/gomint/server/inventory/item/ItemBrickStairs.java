package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:brick_stairs")
public class ItemBrickStairs extends ItemStack<io.gomint.inventory.item.ItemBrickStairs> implements io.gomint.inventory.item.ItemBrickStairs {

    @Override
    public ItemType itemType() {
        return ItemType.BRICK_STAIRS;
    }

}
