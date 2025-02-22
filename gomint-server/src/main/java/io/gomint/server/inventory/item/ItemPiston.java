package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:piston")
public class ItemPiston extends ItemStack<io.gomint.inventory.item.ItemPiston> implements io.gomint.inventory.item.ItemPiston {

    @Override
    public ItemType itemType() {
        return ItemType.PISTON;
    }

}
