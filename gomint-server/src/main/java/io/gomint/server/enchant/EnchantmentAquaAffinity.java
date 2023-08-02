/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.enchant.Rarity;
import io.gomint.inventory.item.ItemType;
import io.gomint.server.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(id = 8)
public class EnchantmentAquaAffinity extends Enchantment implements io.gomint.enchant.EnchantmentAquaAffinity {

    /**
     * Create new enchantment aqua affinity
     */
    public EnchantmentAquaAffinity() {
        super((short) 1);
    }

    @Override
    public int minEnchantAbility(short level) {
        return 1;
    }

    @Override
    public int maxEnchantAbility(short level) {
        return 41;
    }

    @Override
    public boolean canBeApplied(ItemStack<?> itemStack) {
        return itemStack.itemType() == ItemType.CHAIN_HELMET ||
            itemStack.itemType() == ItemType.DIAMOND_HELMET ||
            itemStack.itemType() == ItemType.GOLDEN_HELMET ||
            itemStack.itemType() == ItemType.IRON_HELMET ||
            itemStack.itemType() == ItemType.LEATHER_HELMET ||
            itemStack.itemType() == ItemType.NETHERITE_HELMET;
    }

    @Override
    public Rarity rarity() {
        return Rarity.RARE;
    }

}
