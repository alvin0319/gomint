package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;
import java.time.Duration;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:wooden_slab")
public class ItemWoodenSlab extends ItemStack<io.gomint.inventory.item.ItemWoodenSlab> implements io.gomint.inventory.item.ItemWoodenSlab {

    @Override
    public Duration burnTime() {
        return Duration.ofMillis(15000);
    }

    @Override
    public ItemType itemType() {
        return ItemType.WOODEN_SLAB;
    }

}
