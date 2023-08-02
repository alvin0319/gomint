package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:anvil")
public class ItemAnvil extends ItemStack<io.gomint.inventory.item.ItemAnvil> implements io.gomint.inventory.item.ItemAnvil {

    @Override
    public ItemType itemType() {
        return ItemType.ANVIL;
    }

}
