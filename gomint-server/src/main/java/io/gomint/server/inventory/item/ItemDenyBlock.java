package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:deny")
public class ItemDenyBlock extends ItemStack<io.gomint.inventory.item.ItemDenyBlock> implements io.gomint.inventory.item.ItemDenyBlock {

    @Override
    public ItemType itemType() {
        return ItemType.DENY;
    }

}
