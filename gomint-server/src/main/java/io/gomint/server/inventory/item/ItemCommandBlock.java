package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:command_block")
public class ItemCommandBlock extends ItemStack<ItemCommandBlock> {

    @Override
    public ItemType itemType() {
        return ItemType.COMMAND_BLOCK;
    }

}
