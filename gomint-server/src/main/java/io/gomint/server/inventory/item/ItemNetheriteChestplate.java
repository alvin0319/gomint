package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.Block;
import io.gomint.world.block.data.Facing;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:netherite_chestplate")
public class ItemNetheriteChestplate extends ItemNetheriteArmor<io.gomint.inventory.item.ItemNetheriteChestplate> implements io.gomint.inventory.item.ItemNetheriteChestplate {

    @Override
    public float getReductionValue() {
        return 8;
    }

    @Override
    public boolean interact(EntityPlayer entity, Facing face, Vector clickPosition, Block clickedBlock) {
        if (clickedBlock == null) {
            if (isBetter((ItemStack<?>) entity.armorInventory().chestplate())) {
                ItemStack<?> old = (ItemStack<?>) entity.armorInventory().chestplate();
                entity.armorInventory().chestplate(this);
                entity.inventory().item(entity.inventory().itemInHandSlot(), old);
            }
        }

        return false;
    }

    @Override
    public ItemType itemType() {
        return ItemType.NETHERITE_CHESTPLATE;
    }
}
