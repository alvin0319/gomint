package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemSkull;
import io.gomint.inventory.item.ItemStack;
import io.gomint.math.AxisAlignedBB;
import io.gomint.math.Location;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityLiving;
import io.gomint.server.entity.tileentity.SkullTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.state.BlockfaceFromPlayerBlockState;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockSkull;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Direction;
import io.gomint.world.block.data.Facing;
import io.gomint.world.block.data.SkullType;
import java.util.Collections;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:skull")
public class Skull extends Block implements BlockSkull {

    private static final BlockfaceFromPlayerBlockState DIRECTION = new BlockfaceFromPlayerBlockState(() -> new String[]{"facing_direction"}, true);

    @Override
    public long breakTime() {
        return 1500;
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public List<AxisAlignedBB> boundingBoxes() {
        return Collections.singletonList(new AxisAlignedBB(
            this.location.x() + 0.25f,
            this.location.y(),
            this.location.z() + 0.25f,
            this.location.x() + 0.75f,
            this.location.y() + 0.5f,
            this.location.z() + 0.75f
        ));
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    public boolean beforePlacement(EntityLiving<?> entity, ItemStack<?> item, Facing face, Location location, Vector clickVector) {
        DIRECTION.detectFromPlacement(this, entity, item, face, clickVector);

        // We skip downwards facing
        if (face == Facing.DOWN || face == Facing.UP) {
            DIRECTION.state(this, Facing.UP);
        }

        SkullTileEntity tileEntity = this.tileEntity();
        tileEntity.setRotation(entity.yaw());
        return super.beforePlacement(entity, item, face, location, clickVector);
    }

    @Override
    TileEntity createTileEntity(NBTTagCompound compound) {
        super.createTileEntity(compound);
        return this.tileEntities.construct(SkullTileEntity.class, compound, this, this.items);
    }

    @Override
    public List<ItemStack<?>> drops(ItemStack<?> itemInHand) {
        ItemSkull item = ItemSkull.create(1);
        item.type(this.type());
        return Collections.singletonList(item);
    }

    @Override
    public float blastResistance() {
        return 5.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.SKULL;
    }

    @Override
    public SkullType type() {
        SkullTileEntity entity = this.tileEntity();
        return entity.getSkullType();
    }

    @Override
    public BlockSkull type(SkullType type) {
        SkullTileEntity entity = this.tileEntity();
        entity.setSkullType(type);
        return this;
    }

    @Override
    public BlockSkull direction(Direction direction) {
        if (direction == null) {
            DIRECTION.state(this, Facing.UP);
        } else {
            DIRECTION.state(this, direction.toFacing());
        }

        return this;
    }

    @Override
    public Direction direction() {
        Facing facing = DIRECTION.state(this);
        if (facing == Facing.UP) {
            return null;
        }

        return facing.toDirection();
    }

}
