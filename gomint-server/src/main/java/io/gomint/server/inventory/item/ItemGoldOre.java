package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:gold_ore")
public class ItemGoldOre extends ItemStack<io.gomint.inventory.item.ItemGoldOre> implements io.gomint.inventory.item.ItemGoldOre {

    @Override
    public ItemType itemType() {
        return ItemType.GOLD_ORE;
    }

}
