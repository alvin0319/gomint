package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:cooked_rabbit")
public class ItemCookedRabbit extends ItemFood<io.gomint.inventory.item.ItemCookedRabbit> implements io.gomint.inventory.item.ItemCookedRabbit {


    @Override
    public float getSaturation() {
        return 0.6f;
    }

    @Override
    public float getHunger() {
        return 5;
    }

    @Override
    public ItemType itemType() {
        return ItemType.COOKED_RABBIT;
    }

}
