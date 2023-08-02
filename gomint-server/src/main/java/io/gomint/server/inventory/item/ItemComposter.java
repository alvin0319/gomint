package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:composter")
public class ItemComposter extends ItemStack<io.gomint.inventory.item.ItemComposter> implements io.gomint.inventory.item.ItemComposter {

    @Override
    public ItemType itemType() {
        return ItemType.COMPOSTER;
    }
}
