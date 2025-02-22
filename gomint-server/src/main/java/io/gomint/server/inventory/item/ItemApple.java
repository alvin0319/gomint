package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:apple")
public class ItemApple extends ItemFood<io.gomint.inventory.item.ItemApple> implements io.gomint.inventory.item.ItemApple {


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
        return ItemType.APPLE;
    }

}
