package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:cooked_salmon")
public class ItemCookedSalmon extends ItemFood<io.gomint.inventory.item.ItemCookedSalmon> implements io.gomint.inventory.item.ItemCookedSalmon {


    @Override
    public float getSaturation() {
        return 0.8f;
    }

    @Override
    public float getHunger() {
        return 6;
    }

    @Override
    public ItemType itemType() {
        return ItemType.COOKED_SALMON;
    }

}
