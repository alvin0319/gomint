package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemBanner;
import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;
import java.time.Duration;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:standing_banner")
public class ItemStandingBanner extends ItemStack<ItemBanner> implements ItemBanner {

    @Override
    public Duration burnTime() {
        return Duration.ofMillis(15000);
    }

    @Override
    public ItemType itemType() {
        return ItemType.STANDING_BANNER;
    }

}
