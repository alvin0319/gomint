package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:stone")
public class ItemStone extends ItemStack<io.gomint.inventory.item.ItemStone> implements io.gomint.inventory.item.ItemStone {

    @Override
    public ItemType itemType() {
        return ItemType.STONE;
    }

}
