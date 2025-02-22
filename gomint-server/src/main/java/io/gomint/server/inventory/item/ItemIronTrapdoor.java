package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:iron_trapdoor")
public class ItemIronTrapdoor extends ItemStack<io.gomint.inventory.item.ItemIronTrapdoor> implements io.gomint.inventory.item.ItemIronTrapdoor {

    @Override
    public ItemType itemType() {
        return ItemType.IRON_TRAPDOOR;
    }

}
