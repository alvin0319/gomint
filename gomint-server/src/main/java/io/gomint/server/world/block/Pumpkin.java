package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Location;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityLiving;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.state.DirectionBlockState;
import io.gomint.world.block.BlockPumpkin;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Direction;
import io.gomint.world.block.data.Facing;
import io.gomint.world.block.data.PumpkinType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:pumpkin", def = true)
@RegisterInfo(sId = "minecraft:carved_pumpkin")
public class Pumpkin extends Block implements BlockPumpkin {

    private static final DirectionBlockState DIRECTION = new DirectionBlockState(() -> new String[]{"direction"}); // Rotation is always clockwise

    @Override
    public boolean beforePlacement(EntityLiving<?> entity, ItemStack<?> item, Facing face, Location location, Vector clickVector) {
        super.beforePlacement(entity, item, face, location, clickVector);
        DIRECTION.detectFromPlacement(this, entity, item, face, clickVector);
        return true;
    }

    @Override
    public long breakTime() {
        return 1500;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public float blastResistance() {
        return 5.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.PUMPKIN;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public PumpkinType type() {
        return this.blockId().equals("minecraft:pumpkin") ? PumpkinType.NORMAL : PumpkinType.CARVED;
    }

    @Override
    public BlockPumpkin type(PumpkinType type) {
        this.blockId(type == PumpkinType.NORMAL ? "minecraft:pumpkin" : "minecraft:carved_pumpkin");
        return this;
    }

    @Override
    public BlockPumpkin direction(Direction direction) {
        DIRECTION.state(this, direction);
        return this;
    }

    @Override
    public Direction direction() {
        return DIRECTION.state(this);
    }

}
