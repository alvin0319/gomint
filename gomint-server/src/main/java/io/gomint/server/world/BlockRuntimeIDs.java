/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world;

import io.gomint.jraknet.PacketBuffer;
import io.gomint.server.registry.SwitchBlockStateMapper;
import io.gomint.server.util.BlockIdentifier;
import io.gomint.server.util.collection.ReadOnlyMap;
import io.gomint.server.util.collection.SingleKeyChangeMap;
import io.gomint.server.world.block.Blocks;
import io.gomint.server.world.block.mapper.BlockStateMapper;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.taglib.NBTWriter;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
public class BlockRuntimeIDs {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlockRuntimeIDs.class);

    private static BlockIdentifier[] RUNTIME_TO_BLOCK;

    private static final Object2IntOpenHashMap<String> BLOCK_ID_TO_NUMERIC = new Object2IntOpenHashMap<>();

    // State jumptables
    private static final SwitchBlockStateMapper MAPPER_REGISTRY = new SwitchBlockStateMapper();

    public static void init(List<BlockIdentifier> blockPalette, Blocks blocks) throws IOException {
        BLOCK_ID_TO_NUMERIC.defaultReturnValue(-1);

        List<Object> compounds = new ArrayList<>();

        PacketBuffer data = new PacketBuffer(blockPalette.size() * 128);
        NBTWriter writer = new NBTWriter(data.getBuffer(), ByteOrder.LITTLE_ENDIAN);
        writer.setUseVarint(true);

        RUNTIME_TO_BLOCK = new BlockIdentifier[blockPalette.size()];
        for (BlockIdentifier identifier : blockPalette) {
            int runtime = identifier.runtimeId();

            RUNTIME_TO_BLOCK[runtime] = identifier;
            BLOCK_ID_TO_NUMERIC.put(identifier.blockId(), identifier.numericId());

            NBTTagCompound compound = new NBTTagCompound("");
            NBTTagCompound block = new NBTTagCompound("block");

            block.addValue("name", identifier.blockId());
            block.addValue("states", identifier.nbt());
            compound.addValue("block", block);
            compounds.add(compound);
        }

        writer.write(compounds);
        blocks.setPacketCache(data);
    }

    public static BlockIdentifier toBlockIdentifier(int runtimeId) {
        return RUNTIME_TO_BLOCK[runtimeId];
    }

    public static BlockIdentifier toBlockIdentifier(String blockId, ReadOnlyMap<String, Object> states) {
        BlockStateMapper mapper = MAPPER_REGISTRY.get(BLOCK_ID_TO_NUMERIC.getInt(blockId));
        if (mapper == null) {
            return null; // There is no block for this block id
        }

        int runeTimeId = mapper.map(states);
        if (runeTimeId == -1) {
            LOGGER.error("Unknown states for block id: {}", blockId);
            return null;
        }

        return toBlockIdentifier(runeTimeId);
    }

    /**
     * Get the new block identifier which holds the changes state map
     *
     * @param oldState    from which we get the diff
     * @param newBlockId  new block id to use, can be null if the block id should not be changed
     * @param changingKey key which changes
     * @param newValue    value of this key
     * @return new block identifier or null if no state has been found
     */
    public static BlockIdentifier change(BlockIdentifier oldState, String newBlockId, String[] changingKey, Object newValue) {
        Map<String, Object> changed;
        if (changingKey != null) {
            changed = new SingleKeyChangeMap(oldState.states(), changingKey, newValue);
        } else {
            changed = oldState.states();
        }

        BlockStateMapper mapper = MAPPER_REGISTRY.get(newBlockId != null ? BLOCK_ID_TO_NUMERIC.getInt(newBlockId) : oldState.numericId());
        int runeTimeId = mapper.map(changed);
        if (runeTimeId == -1) {
            LOGGER.warn("No usable block state found for: {} -> {} -> {}", oldState, changingKey, newValue);
            return null;
        }

        return toBlockIdentifier(runeTimeId);
    }

}
