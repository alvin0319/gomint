package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:nether_brick_stairs")
public class ItemNetherBrickStairs extends ItemStack<io.gomint.inventory.item.ItemNetherBrickStairs> implements io.gomint.inventory.item.ItemNetherBrickStairs {

    @Override
    public ItemType itemType() {
        return ItemType.NETHER_BRICK_STAIRS;
    }

}
