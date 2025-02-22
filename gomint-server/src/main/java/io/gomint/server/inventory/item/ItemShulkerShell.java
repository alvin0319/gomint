package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:shulker_shell")
public class ItemShulkerShell extends ItemStack<io.gomint.inventory.item.ItemShulkerShell> implements io.gomint.inventory.item.ItemShulkerShell {


    @Override
    public ItemType itemType() {
        return ItemType.SHULKER_SHELL;
    }

}
