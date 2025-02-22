package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:netherreactor")
public class ItemNetherReactorCore extends ItemStack<io.gomint.inventory.item.ItemNetherReactorCore> implements io.gomint.inventory.item.ItemNetherReactorCore {

    @Override
    public ItemType itemType() {
        return ItemType.NETHER_REACTOR_CORE;
    }

}
