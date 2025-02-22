package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:dragon_breath")
public class ItemDragonBreath extends ItemStack<io.gomint.inventory.item.ItemDragonBreath> implements io.gomint.inventory.item.ItemDragonBreath {


    @Override
    public ItemType itemType() {
        return ItemType.DRAGON_BREATH;
    }

}
