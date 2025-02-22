package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.state.EnumBlockState;
import io.gomint.world.block.BlockStainedGlassPane;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.BlockColor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:stained_glass_pane")
public class StainedGlassPane extends Block implements BlockStainedGlassPane {

    private static final EnumBlockState<BlockColor, String> COLOR = new EnumBlockState<>(v -> new String[]{"color"}, BlockColor.values(), e -> e.name().toLowerCase(), v -> BlockColor.valueOf(v.toUpperCase()));

    @Override
    public String blockId() {
        return "minecraft:stained_glass_pane";
    }

    @Override
    public long breakTime() {
        return 450;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public List<ItemStack<?>> drops(ItemStack<?> itemInHand) {
        return new ArrayList<>();
    }

    @Override
    public float blastResistance() {
        return 1.5f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.STAINED_GLASS_PANE;
    }

    @Override
    public BlockColor color() {
        return COLOR.state(this);
    }

    @Override
    public BlockStainedGlassPane color(BlockColor color) {
        COLOR.state(this, color);
        return this;
    }

}
