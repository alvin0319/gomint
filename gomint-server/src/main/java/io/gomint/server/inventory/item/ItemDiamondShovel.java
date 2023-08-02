package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.math.Vector;
import io.gomint.server.entity.Attribute;
import io.gomint.server.entity.AttributeModifier;
import io.gomint.server.entity.AttributeModifierType;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.GrassBlock;
import io.gomint.server.world.block.GrassPath;
import io.gomint.world.block.Block;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:diamond_shovel")
public class ItemDiamondShovel extends ItemReduceTierDiamond<io.gomint.inventory.item.ItemDiamondShovel> implements io.gomint.inventory.item.ItemDiamondShovel {

    @Override
    public boolean interact(EntityPlayer entity, Facing face, Vector clickPosition, Block clickedBlock) {
        if (clickedBlock instanceof GrassBlock) {
            clickedBlock.blockType(GrassPath.class);
            this.calculateUsageAndUpdate(1);
            return true;
        }

        return false;
    }

    @Override
    public void gotInHand(EntityPlayer player) {
        player
            .attributeInstance(Attribute.ATTACK_DAMAGE)
            .setModifier(AttributeModifier.ITEM_ATTACK_DAMAGE, AttributeModifierType.ADDITION, 5);
    }

    @Override
    public void removeFromHand(EntityPlayer player) {
        player
            .attributeInstance(Attribute.ATTACK_DAMAGE)
            .removeModifier(AttributeModifier.ITEM_ATTACK_DAMAGE);
    }

    @Override
    public ItemType itemType() {
        return ItemType.DIAMOND_SHOVEL;
    }

}
