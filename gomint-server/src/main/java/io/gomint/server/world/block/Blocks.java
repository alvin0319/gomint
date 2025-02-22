package io.gomint.server.world.block;

import io.gomint.entity.Entity;
import io.gomint.event.world.BlockPlaceEvent;
import io.gomint.inventory.item.ItemStack;
import io.gomint.jraknet.PacketBuffer;
import io.gomint.math.AxisAlignedBB;
import io.gomint.math.BlockPosition;
import io.gomint.math.Location;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.entity.tileentity.TileEntities;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.inventory.item.Items;
import io.gomint.server.maintenance.ReportUploader;
import io.gomint.server.registry.BlockRegistry;
import io.gomint.server.registry.Generator;
import io.gomint.server.util.BlockIdentifier;
import io.gomint.server.util.ClassPath;
import io.gomint.server.util.performance.ASMFactoryConstructionFactory;
import io.gomint.server.util.performance.ConstructionFactory;
import io.gomint.server.world.BlockRuntimeIDs;
import io.gomint.server.world.ChunkSlice;
import io.gomint.server.world.WorldAdapter;
import io.gomint.world.block.data.Facing;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
public class Blocks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Blocks.class);
    private static long lastReport = 0;
    private BlockRegistry generators;
    private PacketBuffer packetCache;

    public void init(ClassPath classPath, Items items, TileEntities tileEntities, List<BlockIdentifier> blockIdentifiers) throws IOException {
        this.generators = new BlockRegistry(blockIdentifiers, (clazz, id) -> {
            ConstructionFactory<Block> factory = ASMFactoryConstructionFactory.create(clazz);

            return in -> {
                return factory
                    .newInstance()
                    .items(items)
                    .tileEntities(tileEntities)
                    .identifier(id.blockIdentifier());
            };
        });

        BlockRuntimeIDs.init(blockIdentifiers, this);

        this.generators.register(classPath, "io.gomint.server.world.block");
        this.generators.cleanup();
    }

    public PacketBuffer packetCache() {
        return this.packetCache;
    }

    public <T extends Block> T get(BlockIdentifier identifier, byte skyLightLevel, byte blockLightLevel,
                                   TileEntity tileEntity, Location location, BlockPosition blockPosition, int layer, ChunkSlice chunkSlice, short index) {
        Generator<Block> instance = this.generators.getGenerator(identifier.runtimeId());
        if (instance != null) {
            T block = (T) instance.generate();
            if (location == null) {
                return block;
            }

            block.setData(identifier, tileEntity, (WorldAdapter) location.world(), location, blockPosition, layer, skyLightLevel, blockLightLevel, chunkSlice, index);
            return block;
        }

        // Don't spam the report server pls
        if (System.currentTimeMillis() - lastReport > TimeUnit.SECONDS.toSeconds(10)) {
            LOGGER.warn("Missing block: {}", identifier);
            ReportUploader.create().includeWorlds().property("missing_block", identifier.toString()).upload("Missing block in register");
            lastReport = System.currentTimeMillis();
        }

        LOGGER.warn("Unknown block {} @ {}", identifier.blockId(), location, new Exception());
        return null;
    }

    public Block get(BlockIdentifier identifier) {
        Generator<Block> instance = this.generators.getGenerator(identifier.runtimeId());
        if (instance != null) {
            return instance.generate();
        }

        LOGGER.warn("Unknown block {}", identifier.blockId());
        return null;
    }

    public <T extends io.gomint.world.block.Block> T get(Class<T> apiInterface) {
        Generator<Block> instance = this.generators.getGenerator(apiInterface);
        if (instance != null) {
            return (T) instance.generate();
        }

        return null;
    }

    public String getID(Class<?> block) {
        return this.generators.getID(block);
    }

    public boolean replaceWithItem(Block newBlock, EntityPlayer entity, Block clickedBlock, Block block, Facing face, ItemStack<?> item, Vector clickVector) {
        WorldAdapter adapter = (WorldAdapter) block.location.world();

        newBlock.location = block.location;
        newBlock.position = block.position;
        newBlock.world = adapter;

        if (!newBlock.beforePlacement(entity, item, face, block.location, clickVector)) {
            return false;
        }

        // Check only solid blocks for bounding box intersects
        if (newBlock.solid()) {
            List<AxisAlignedBB> bbs = newBlock.boundingBoxes();
            if (bbs != null) {
                for (AxisAlignedBB bb : bbs) {
                    // Check other entities in the bounding box
                    Collection<Entity<?>> collidedWith = adapter.getNearbyEntities(bb, null);
                    if (collidedWith != null) {
                        return false;
                    }
                }
            }
        }

        // We decided that the block would fit
        BlockPlaceEvent blockPlaceEvent = new BlockPlaceEvent(entity, clickedBlock, block, item, newBlock);
        block.world.server().pluginManager().callEvent(blockPlaceEvent);

        if (blockPlaceEvent.cancelled()) {
            return false;
        }

        newBlock.place();
        newBlock.afterPlacement();
        return true;
    }

    public void setPacketCache(PacketBuffer packetCache) {
        this.packetCache = packetCache;
    }

}
