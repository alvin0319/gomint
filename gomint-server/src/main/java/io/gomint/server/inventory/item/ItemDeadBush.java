package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:deadbush")
public class ItemDeadBush extends ItemStack<io.gomint.inventory.item.ItemDeadBush> implements io.gomint.inventory.item.ItemDeadBush {

    @Override
    public ItemType itemType() {
        return ItemType.DEAD_BUSH;
    }

}
