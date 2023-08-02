/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.enchant.Rarity;
import io.gomint.server.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(id = 7)
public class EnchantmentDepthStrider extends Enchantment implements io.gomint.enchant.EnchantmentDepthStrider {

    /**
     * Create new enchantment depth strider
     */
    public EnchantmentDepthStrider() {
        super((short) 3);
    }

    @Override
    public int minEnchantAbility(short level) {
        return (byte) (level * 10);
    }

    @Override
    public int maxEnchantAbility(short level) {
        return (byte) (minEnchantAbility(level) + 15);
    }

    @Override
    public boolean canBeApplied(ItemStack<?> itemStack) {
        return EnchantmentHelper.canBeAppliedToBoots(itemStack);
    }

    @Override
    public Rarity rarity() {
        return Rarity.RARE;
    }

    @Override
    public boolean collidesWith(Enchantment enchantment) {
        return enchantment instanceof EnchantmentFrostWalker ||
            super.collidesWith(enchantment);
    }

}
