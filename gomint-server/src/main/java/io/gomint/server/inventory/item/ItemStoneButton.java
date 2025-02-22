package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:stone_button")
public class ItemStoneButton extends ItemStack<io.gomint.inventory.item.ItemStoneButton> implements io.gomint.inventory.item.ItemStoneButton {

    @Override
    public ItemType itemType() {
        return ItemType.STONE_BUTTON;
    }

}
