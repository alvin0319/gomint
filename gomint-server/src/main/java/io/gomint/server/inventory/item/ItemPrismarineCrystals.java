package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:prismarine_crystals")
public class ItemPrismarineCrystals extends ItemStack<io.gomint.inventory.item.ItemPrismarineCrystals> implements io.gomint.inventory.item.ItemPrismarineCrystals {


    @Override
    public ItemType itemType() {
        return ItemType.PRISMARINE_CRYSTALS;
    }

}
