package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:glowstone_dust")
public class ItemGlowstoneDust extends ItemStack<io.gomint.inventory.item.ItemGlowstoneDust> implements io.gomint.inventory.item.ItemGlowstoneDust {


    @Override
    public ItemType itemType() {
        return ItemType.GLOWSTONE_DUST;
    }

}
