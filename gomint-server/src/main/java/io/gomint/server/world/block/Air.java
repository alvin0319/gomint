package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockAir;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:air")
public class Air extends Block implements BlockAir {

    @Override
    public String blockId() {
        return "minecraft:air";
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public boolean solid() {
        return false;
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    @Override
    public boolean onBreak(boolean creative) {
        return false;
    }

    @Override
    public boolean canBeReplaced(ItemStack<?> item) {
        return this.location.y() > -1 && this.location.y() < 256;
    }

    @Override
    public float blastResistance() {
        return 0.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.AIR;
    }

    @Override
    public boolean canBeFlowedInto() {
        return true;
    }

}
