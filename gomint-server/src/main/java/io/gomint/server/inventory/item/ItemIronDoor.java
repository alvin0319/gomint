package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:iron_door")
public class ItemIronDoor extends ItemStack<io.gomint.inventory.item.ItemIronDoor> implements io.gomint.inventory.item.ItemIronDoor {

    @Override
    public ItemType itemType() {
        return ItemType.IRON_DOOR;
    }

}
