package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:slime_ball")
public class ItemSlimeball extends ItemStack<io.gomint.inventory.item.ItemSlimeball> implements io.gomint.inventory.item.ItemSlimeball {


    @Override
    public ItemType itemType() {
        return ItemType.SLIMEBALL;
    }

}
