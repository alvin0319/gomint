package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:painting")
public class ItemPainting extends ItemStack<io.gomint.inventory.item.ItemPainting> implements io.gomint.inventory.item.ItemPainting {


    @Override
    public ItemType itemType() {
        return ItemType.PAINTING;
    }

}
