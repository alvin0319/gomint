package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemSword;
import io.gomint.inventory.item.ItemType;
import io.gomint.server.entity.Attribute;
import io.gomint.server.entity.AttributeModifier;
import io.gomint.server.entity.AttributeModifierType;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:stone_sword")
public class ItemStoneSword extends ItemReduceTierSpecial<io.gomint.inventory.item.ItemStoneSword> implements io.gomint.inventory.item.ItemStoneSword, ItemSword {

    @Override
    public void gotInHand(EntityPlayer player) {
        player
            .attributeInstance(Attribute.ATTACK_DAMAGE)
            .setModifier(AttributeModifier.ITEM_ATTACK_DAMAGE, AttributeModifierType.ADDITION, 5); // 4 from sword type, 1 from stone material
    }

    @Override
    public void removeFromHand(EntityPlayer player) {
        player
            .attributeInstance(Attribute.ATTACK_DAMAGE)
            .removeModifier(AttributeModifier.ITEM_ATTACK_DAMAGE);
    }

    @Override
    public ItemType itemType() {
        return ItemType.STONE_SWORD;
    }

    @Override
    public int enchantAbility() {
        return 5;
    }

}
