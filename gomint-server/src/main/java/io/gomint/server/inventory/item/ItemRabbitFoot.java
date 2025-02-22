package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:rabbit_foot")
public class ItemRabbitFoot extends ItemStack<io.gomint.inventory.item.ItemRabbitFoot> implements io.gomint.inventory.item.ItemRabbitFoot {


    @Override
    public ItemType itemType() {
        return ItemType.RABBIT_FOOT;
    }

}
