package io.gomint.server.world.block;

import io.gomint.inventory.item.*;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockLapisLazuliOre;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:lapis_ore")
public class LapisLazuliOre extends Block implements BlockLapisLazuliOre {

    @Override
    public String blockId() {
        return "minecraft:lapis_ore";
    }

    @Override
    public long breakTime() {
        return 4500;
    }

    @Override
    public float blastResistance() {
        return 5.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.LAPIS_LAZULI_ORE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return new Class[]{
            ItemDiamondPickaxe.class,
            ItemIronPickaxe.class,
            ItemGoldenPickaxe.class,
            ItemStonePickaxe.class
        };
    }

}
