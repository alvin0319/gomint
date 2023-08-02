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
@RegisterInfo(id = 21)
public class EnchantmentFlame extends Enchantment implements io.gomint.enchant.EnchantmentFlame {

    /**
     * Create new enchantment fire
     */
    public EnchantmentFlame() {
        super((short) 1);
    }

    @Override
    public int minEnchantAbility(short level) {
        return 20;
    }

    @Override
    public int maxEnchantAbility(short level) {
        return 50;
    }

    @Override
    public boolean canBeApplied(ItemStack<?> itemStack) {
        return itemStack.itemType() == ItemType.BOW;
    }

    @Override
    public Rarity rarity() {
        return Rarity.RARE;
    }

}
