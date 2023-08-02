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
@RegisterInfo(id = 19)
public class EnchantmentPower extends Enchantment implements io.gomint.enchant.EnchantmentPower {

    /**
     * Create new enchantment power
     */
    public EnchantmentPower() {
        super((short) 5);
    }

    @Override
    public int minEnchantAbility(short level) {
        return (byte) (1 + (level - 1) * 10);
    }

    @Override
    public int maxEnchantAbility(short level) {
        return (byte) (minEnchantAbility(level) + 15);
    }

    @Override
    public boolean canBeApplied(ItemStack<?> itemStack) {
        return itemStack.itemType() == ItemType.BOW;
    }

    @Override
    public Rarity rarity() {
        return Rarity.COMMON;
    }

}
