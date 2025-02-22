package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:grass")
public class ItemGrassBlock extends ItemStack<io.gomint.inventory.item.ItemGrassBlock> implements io.gomint.inventory.item.ItemGrassBlock {

    @Override
    public ItemType itemType() {
        return ItemType.GRASS_BLOCK;
    }

}
