package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.Block;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:leather_boots")
public class ItemLeatherBoots extends ItemLeatherArmor<io.gomint.inventory.item.ItemLeatherBoots> implements io.gomint.inventory.item.ItemLeatherBoots {

    @Override
    public float getReductionValue() {
        return 1;
    }

    @Override
    public boolean interact(EntityPlayer entity, Facing face, Vector clickPosition, Block clickedBlock) {
        if (clickedBlock == null) {
            if (isBetter((ItemStack<?>) entity.armorInventory().boots())) {
                ItemStack<?> old = (ItemStack<?>) entity.armorInventory().boots();
                entity.armorInventory().boots(this);
                entity.inventory().item(entity.inventory().itemInHandSlot(), old);
            }
        }

        return false;
    }

    @Override
    public ItemType itemType() {
        return ItemType.LEATHER_BOOTS;
    }

}
