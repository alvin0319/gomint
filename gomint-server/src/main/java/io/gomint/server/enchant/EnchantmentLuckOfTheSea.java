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
@RegisterInfo(id = 23)
public class EnchantmentLuckOfTheSea extends Enchantment implements io.gomint.enchant.EnchantmentLuckOfTheSea {

    /**
     * Create new enchantment luck of the sea
     */
    public EnchantmentLuckOfTheSea() {
        super((short) 3);
    }

    @Override
    public int minEnchantAbility(short level) {
        return (byte) (15 + (level - 1) * 9);
    }

    @Override
    public int maxEnchantAbility(short level) {
        return (byte) (minEnchantAbility(level) + 50);
    }

    @Override
    public boolean canBeApplied(ItemStack<?> itemStack) {
        return itemStack.itemType() == ItemType.FISHING_ROD;
    }

    @Override
    public Rarity rarity() {
        return Rarity.RARE;
    }

}
