package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:chorus_fruit")
public class ItemChorusFruit extends ItemFood<io.gomint.inventory.item.ItemChorusFruit> implements io.gomint.inventory.item.ItemChorusFruit {


    @Override
    public float getSaturation() {
        return 0.3f;
    }

    @Override
    public float getHunger() {
        return 4;
    }

    @Override
    public ItemType itemType() {
        return ItemType.CHORUS_FRUIT;
    }

}
