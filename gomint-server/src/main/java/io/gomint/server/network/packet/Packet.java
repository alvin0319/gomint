/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.network.packet;

import io.gomint.GoMint;
import io.gomint.inventory.item.ItemAir;
import io.gomint.inventory.item.ItemStack;
import io.gomint.jraknet.PacketBuffer;
import io.gomint.math.BlockPosition;
import io.gomint.math.Vector;
import io.gomint.server.GoMintServer;
import io.gomint.server.entity.EntityLink;
import io.gomint.server.network.Protocol;
import io.gomint.server.network.packet.types.gamerule.*;
import io.gomint.server.network.packet.types.recipe.*;
import io.gomint.server.network.packet.util.PacketDecodeException;
import io.gomint.server.network.type.CommandOrigin;
import io.gomint.server.player.PlayerSkin;
import io.gomint.server.util.Things;
import io.gomint.taglib.AllocationLimitReachedException;
import io.gomint.taglib.NBTReader;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.taglib.NBTWriter;
import io.gomint.world.Gamerule;
import io.gomint.world.block.data.Facing;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BlackyPaw
 * @version 1.0
 */
public abstract class Packet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Packet.class);
    private static final float BYTE_ROTATION_DIVIDOR = 360f / 256f;

    /**
     * Internal MC:PE id of this packet
     */
    protected final int id;

    /**
     * Construct a new packet
     *
     * @param id of the packet
     */
    protected Packet(int id) {
        this.id = id;
    }

    /**
     * Read a item stack from the packet buffer
     *
     * @param buffer from the packet
     * @return read item stack
     */
    public static ItemStack<?> readItemStack(PacketBuffer buffer) {
        int id = buffer.readSignedVarInt();
        if (id == 0) {
            return ItemAir.create(0);
        }

        int temp = buffer.readSignedVarInt();
        byte amount = (byte) (temp & 0xFF);
        short data = (short) (temp >> 8);

        NBTTagCompound nbt = null;
        short extraLen = buffer.readLShort();
        if (extraLen == -1) {
            // New system uses a byte as amount of nbt tags
            byte version = buffer.readByte();

            try {
                NBTReader nbtReader = new NBTReader(buffer.getBuffer(), ByteOrder.LITTLE_ENDIAN);
                nbtReader.setUseVarint(true);
                // There is no alloc limit needed here, you can't write so much shit in 32kb, so thats ok
                nbt = nbtReader.parse();
            } catch (IOException | AllocationLimitReachedException e) {
                LOGGER.error("Could not read item stack because of NBT", e);
                return ItemAir.create(0);
            }
        }

        // They implemented additional data for item stacks aside from nbt
        int countPlacedOn = buffer.readSignedVarInt();
        for (int i = 0; i < countPlacedOn; i++) {
            buffer.readString();    // TODO: Implement proper support once we know the string values
        }

        int countCanBreak = buffer.readSignedVarInt();
        for (int i = 0; i < countCanBreak; i++) {
            buffer.readString();    // TODO: Implement proper support once we know the string values
        }

        ItemStack<?> itemStack = ((GoMintServer) GoMint.instance()).items().create(id, data, amount, nbt);

        // New item data system?
        ((io.gomint.server.inventory.item.ItemStack<?>) itemStack).readAdditionalData(buffer);

        return itemStack;
    }

    public static ItemStack<?> readItemStackWithID(PacketBuffer buffer) {
        int id = buffer.readSignedVarInt();
        io.gomint.server.inventory.item.ItemStack<?> serverItemStack = (io.gomint.server.inventory.item.ItemStack<?>) readItemStack(buffer);
        if (serverItemStack != null) {
            serverItemStack.stackId(id);
        }

        return serverItemStack;
    }

    public static void writeItemStackWithID(ItemStack<?> itemStack, PacketBuffer buffer) {
        io.gomint.server.inventory.item.ItemStack<?> serverItemStack = (io.gomint.server.inventory.item.ItemStack<?>) itemStack;

        if (serverItemStack.stackId() == 0) {
            buffer.writeSignedVarInt(0);
            return;
        }

        writeItemStack(itemStack, buffer, serverItemStack.stackId());
    }

    /**
     * Write a item stack without stack id to the packet buffer
     * @param itemStack which should be written
     * @param buffer which should be used to write to
     */
    public static void writeItemStack(ItemStack<?> itemStack, PacketBuffer buffer) {
        writeItemStack(itemStack, buffer, null);
    }

    /**
     * Write a item stack to the packet buffer
     *
     * @param itemStack which should be written
     * @param buffer    which should be used to write to
     * @param stackId   the item stack id if this should be written
     */
    public static void writeItemStack(ItemStack<?> itemStack, PacketBuffer buffer, @Nullable Integer stackId) {
        if (itemStack instanceof ItemAir) {
            buffer.writeSignedVarInt(0);
            return;
        }

        io.gomint.server.inventory.item.ItemStack<?> serverItemStack = (io.gomint.server.inventory.item.ItemStack<?>) itemStack;

        buffer.writeSignedVarInt(serverItemStack.runtimeID());
//        buffer.writeSignedVarInt(((serverItemStack.data() & 0x7fff) << 8) + (itemStack.amount() & 0xff));
        buffer.writeLShort(serverItemStack.amount());
        buffer.writeUnsignedVarInt(serverItemStack.data());

        if (stackId != null) {
            buffer.writeBoolean(stackId != 0);
            if (stackId != 0) {
                buffer.writeSignedVarInt(stackId);
            }
        }

        NBTTagCompound compound = serverItemStack.nbtData();
        if (compound == null) {
            buffer.writeLShort((short) 0);
        } else {
            try {
                // Vanilla currently only writes one nbt tag (this is hardcoded)
                buffer.writeLShort((short) 0xFFFF);
                buffer.writeByte((byte) 1);

                // NBT Tag
                NBTWriter nbtWriter = new NBTWriter(buffer.getBuffer(), ByteOrder.LITTLE_ENDIAN);
                nbtWriter.setUseVarint(true);
                nbtWriter.write(compound);
            } catch (IOException e) {
                LOGGER.warn("Could not write NBT Tag", e);
            }
        }

        // canPlace and canBreak
        buffer.writeLInt(0); // canPlace
        buffer.writeLInt(0); // canBreak

        // TODO: Shield blocking tick

        ((io.gomint.server.inventory.item.ItemStack<?>) itemStack).writeAdditionalData(buffer);
    }

    public static void writeRecipeInput(ItemStack<?> ingredient, PacketBuffer buffer) {
        if (ingredient == null) {
            buffer.writeSignedVarInt(0);
            return;
        }

        io.gomint.server.inventory.item.ItemStack<?> impl = ((io.gomint.server.inventory.item.ItemStack<?>) ingredient);
        int material = impl.runtimeID();
        buffer.writeSignedVarInt(material);
        buffer.writeSignedVarInt(impl.data());
        buffer.writeSignedVarInt(ingredient.amount());
    }

    public static void writeRecipeIngredient(RecipeIngredient ingredient, PacketBuffer buffer) {
        ItemDescriptor type = ingredient.getItemDescriptor();
        buffer.writeByte((byte) (type == null ? 0 : type.getTypeId()));
        if (type != null) {
            type.write(buffer);
        }
        buffer.writeSignedVarInt(ingredient.getCount());
    }

    public static RecipeIngredient getRecipeIngredient(PacketBuffer buffer) {
        int descriptorType = buffer.readByte();
        ItemDescriptor descriptor = null;
        switch (descriptorType) {
            case ItemDescriptorType.INT_ID_META:
                descriptor = IntIdMetaItemDescriptor.read(buffer);
                break;
            case ItemDescriptorType.STRING_ID_META:
                descriptor = StringIdMetaItemDescriptor.read(buffer);
                break;
            case ItemDescriptorType.TAG:
                descriptor = TagItemDescriptor.read(buffer);
                break;
            case ItemDescriptorType.MOLANG:
                descriptor = MolangItemDescriptor.read(buffer);
                break;
            case ItemDescriptorType.COMPLEX_ALIAS:
                descriptor = ComplexAliasItemDescriptor.read(buffer);
                break;
            default:
                break;
        }
        int count = buffer.readSignedVarInt();
        return new RecipeIngredient(descriptor, count);
    }

    public static Map<String, GameRule> getGameRules(PacketBuffer buffer) {
        int count = buffer.readUnsignedVarInt();
        Map<String, GameRule> gameRules = new HashMap<>(count);
        for (int i = 0; i < count; ++i) {
            String name = buffer.readString();
            boolean isPlayerModifiable = buffer.readBoolean();
            int type = buffer.readUnsignedVarInt();
            gameRules.put(name, readGameRule(buffer, type, isPlayerModifiable));
        }
        return gameRules;
    }

    private static GameRule readGameRule(PacketBuffer buffer, int type, boolean isPlayerModifiable) {
        switch (type) {
            case GameRuleType.BOOLEAN:
                return BooleanGameRule.decode(buffer, isPlayerModifiable);
            case GameRuleType.INTEGER:
                return IntegerGameRule.decode(buffer, isPlayerModifiable);
            case GameRuleType.FLOAT:
                return FloatGameRule.decode(buffer, isPlayerModifiable);
            default:
                throw new PacketDecodeException("Unknown game rule type: " + type);
        }
    }

    public static void writeGameRules(PacketBuffer buffer, Map<String, GameRule> gameRules) {
        buffer.writeUnsignedVarInt(gameRules.size());
        for (Map.Entry<String, GameRule> entry : gameRules.entrySet()) {
            buffer.writeString(entry.getKey());
            buffer.writeBoolean(entry.getValue().isPlayerModifiable());
            buffer.writeUnsignedVarInt(entry.getValue().getTypeId());
            entry.getValue().encode(buffer);
        }
    }

    /**
     * Gets the packet's ID.
     *
     * @return The packet's ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Serializes this packet into the given buffer.
     *
     * @param buffer     The buffer to serialize this packet into
     * @param protocolID Protocol for which we request the serialization
     */
    public abstract void serialize(PacketBuffer buffer, int protocolID) throws Exception;

    /**
     * Deserializes this packet from the given buffer.
     *
     * @param buffer     The buffer to deserialize this packet from
     * @param protocolID Protocol for which we request deserialization
     */
    public abstract void deserialize(PacketBuffer buffer, int protocolID) throws Exception;

    /**
     * Returns the ordering channel to send the packet on.
     *
     * @return The ordering channel of the packet
     */
    public int orderingChannel() {
        return 0;
    }

    /**
     * Write a array of item stacks to the buffer
     *
     * @param itemStacks which should be written to the buffer
     * @param buffer     which should be written to
     */
    void writeItemStacks(ItemStack<?>[] itemStacks, PacketBuffer buffer) {
        if (itemStacks == null || itemStacks.length == 0) {
            buffer.writeUnsignedVarInt(0);
            return;
        }

        buffer.writeUnsignedVarInt(itemStacks.length);

        for (ItemStack<?> itemStack : itemStacks) {
            writeItemStack(itemStack, buffer);
        }
    }

    /**
     * Read in a variable amount of itemstacks
     *
     * @param buffer The buffer to read from
     * @return a list of item stacks
     */
    public static ItemStack<?>[] readItemStacks(PacketBuffer buffer) {
        int count = buffer.readUnsignedVarInt();
        ItemStack<?>[] itemStacks = new ItemStack[count];

        for (int i = 0; i < count; i++) {
            itemStacks[i] = readItemStack(buffer);
        }

        return itemStacks;
    }

    /**
     * Write a array of item stacks to the buffer
     *
     * @param itemStacks which should be written to the buffer
     * @param buffer     which should be written to
     */
    void writeItemStacksWithIDs(ItemStack<?>[] itemStacks, PacketBuffer buffer) {
        buffer.writeUnsignedVarInt(itemStacks.length);

        for (ItemStack<?> itemStack : itemStacks) {
            writeItemStackWithID(itemStack, buffer);
        }
    }

    /**
     * Read in a variable amount of itemstacks
     *
     * @param buffer The buffer to read from
     * @return a list of item stacks
     */
    public static ItemStack<?>[] readItemStacksWithIDs(PacketBuffer buffer) {
        int count = buffer.readUnsignedVarInt();
        ItemStack<?>[] itemStacks = new ItemStack[count];

        for (int i = 0; i < count; i++) {
            itemStacks[i] = readItemStackWithID(buffer);
        }

        return itemStacks;
    }

    /**
     * Write a array of integers to the buffer
     *
     * @param integers which should be written to the buffer
     * @param buffer   which should be written to
     */
    void writeIntList(int[] integers, PacketBuffer buffer) {
        if (integers == null || integers.length == 0) {
            buffer.writeUnsignedVarInt(0);
            return;
        }

        buffer.writeUnsignedVarInt(integers.length);

        for (Integer integer : integers) {
            buffer.writeSignedVarInt(integer);
        }
    }

    public void writeGamerules(Map<Gamerule<?>, Object> gamerules, PacketBuffer buffer) {
        if (gamerules == null) {
            buffer.writeUnsignedVarInt(0);
            return;
        }

        buffer.writeUnsignedVarInt(gamerules.size());
        gamerules.forEach((gamerule, value) -> {
            buffer.writeString(gamerule.name().toLowerCase());

            if (gamerule.valueType() == Boolean.class) {
                buffer.writeByte((byte) 1);
                buffer.writeBoolean((Boolean) value);
            } else if (gamerule.valueType() == Integer.class) {
                buffer.writeByte((byte) 2);
                buffer.writeUnsignedVarInt((Integer) value);
            } else if (gamerule.valueType() == Float.class) {
                buffer.writeByte((byte) 3);
                buffer.writeLFloat((Float) value);
            }
        });
    }

    public Map<Gamerule<?>, Object> readGamerules(PacketBuffer buffer) {
        int amount = buffer.readUnsignedVarInt();
        if (amount == 0) {
            return null;
        }

        Map<Gamerule<?>, Object> gamerules = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            String name = buffer.readString();
            byte type = buffer.readByte();

            Object val = null;
            switch (type) {
                case 1:
                    val = buffer.readBoolean();
                    break;
                case 2:
                    val = buffer.readUnsignedVarInt();
                    break;
                case 3:
                    val = buffer.readLFloat();
                    break;
            }
        }

        return gamerules;
    }

    void writeSerializedSkin(PlayerSkin skin, PacketBuffer buffer) {
        buffer.writeString(skin.id());
        buffer.writeString(""); // PlayFab Id
        buffer.writeString(skin.resourcePatch());
        writeSkinImageData(buffer, skin.imageWidth(), skin.imageHeight(), skin.data());

        if (skin.animations() != null) {
            buffer.writeLInt(skin.animations().size());

            for (PlayerSkin.AnimationFrame animationObj : skin.animations()) {
                writeSkinImageData(buffer, animationObj.getWidth(), animationObj.getHeight(), animationObj.getData());
                buffer.writeLInt(animationObj.getType());
                buffer.writeLFloat(animationObj.getFrames());
                buffer.writeLInt(animationObj.getExpression());
            }
        } else {
            buffer.writeLInt(0);
        }

        writeSkinImageData(buffer, skin.capeImageWidth(), skin.capeImageHeight(), skin.capeData());
        buffer.writeString(skin.geometry());
        buffer.writeString(Protocol.MINECRAFT_PE_NETWORK_VERSION); // geometry data engine version
        buffer.writeString(skin.animationData());
        buffer.writeString(skin.capeId());
        buffer.writeString(skin.fullId());
        buffer.writeString(skin.armSize());
        buffer.writeString(skin.colour());

        if (skin.personaPieces() != null) {
            buffer.writeLInt(skin.personaPieces().size());

            for (PlayerSkin.PersonaPiece personaPieceObj : skin.personaPieces()) {
                buffer.writeString(personaPieceObj.getPieceId());
                buffer.writeString(personaPieceObj.getPieceType());
                buffer.writeString(personaPieceObj.getPackId());
                buffer.writeBoolean(personaPieceObj.isDefaultValue());
                buffer.writeString(personaPieceObj.getProductId());
            }
        } else {
            buffer.writeLInt(0);
        }

        if (skin.pieceTintColours() != null) {
            buffer.writeLInt(skin.pieceTintColours().size());

            for (PlayerSkin.PieceTintColor pieceTintColorObj : skin.pieceTintColours()) {
                buffer.writeString(pieceTintColorObj.getPieceType());

                if (pieceTintColorObj.getColors() != null) {
                    buffer.writeLInt(pieceTintColorObj.getColors().size());
                    for (String color : pieceTintColorObj.getColors()) {
                        buffer.writeString(color);
                    }
                } else {
                    buffer.writeUnsignedVarInt(0);
                }
            }
        } else {
            buffer.writeLInt(0);
        }
        buffer.writeBoolean(skin.premium());
        buffer.writeBoolean(skin.persona());
        buffer.writeBoolean(skin.personaCapeOnClassic());
        buffer.writeBoolean(true); // isPrimaryUser
        buffer.writeBoolean(true); // isOverride
    }

    private void writeSkinImageData(PacketBuffer buffer, int imageWidth, int imageHeight, byte[] data) {
        buffer.writeLInt(imageWidth);
        buffer.writeLInt(imageHeight);
        buffer.writeUnsignedVarInt(data.length);
        buffer.writeBytes(data);
    }

    public static BlockPosition readBlockPosition(PacketBuffer buffer) {
        return new BlockPosition(buffer.readSignedVarInt(), buffer.readUnsignedVarInt(), buffer.readSignedVarInt());
    }

    public BlockPosition readSignedBlockPosition(PacketBuffer buffer) {
        return new BlockPosition(buffer.readSignedVarInt(), buffer.readSignedVarInt(), buffer.readSignedVarInt());
    }

    public static void writeBlockPosition(BlockPosition position, PacketBuffer buffer) {
        buffer.writeSignedVarInt(position.x());
        buffer.writeUnsignedVarInt(position.y());
        buffer.writeSignedVarInt(position.z());
    }

    public void writeSignedBlockPosition(BlockPosition position, PacketBuffer buffer) {
        buffer.writeSignedVarInt(position.x());
        buffer.writeSignedVarInt(position.y());
        buffer.writeSignedVarInt(position.z());
    }

    public void writeEntityLinks(List<EntityLink> links, PacketBuffer buffer) {
        if (links == null) {
            buffer.writeUnsignedVarInt(0);
        } else {
            buffer.writeUnsignedVarInt(links.size());
            for (EntityLink link : links) {
                buffer.writeUnsignedVarLong(link.getFrom());
                buffer.writeUnsignedVarLong(link.getTo());
                buffer.writeByte(link.getUnknown1());
                buffer.writeByte(link.getUnknown2());
            }
        }
    }

    public static void writeVector(Vector vector, PacketBuffer buffer) {
        buffer.writeLFloat(vector.x());
        buffer.writeLFloat(vector.y());
        buffer.writeLFloat(vector.z());
    }

    public static Vector readVector(PacketBuffer buffer) {
        return new Vector(buffer.readLFloat(), buffer.readLFloat(), buffer.readLFloat());
    }

    CommandOrigin readCommandOrigin(PacketBuffer buffer) {
        // Seems to be 0, request uuid, 0, type (0 for player, 3 for server)
        return new CommandOrigin(buffer.readByte(), buffer.readUUID(), buffer.readByte(), buffer.readByte());
    }

    void writeCommandOrigin(CommandOrigin commandOrigin, PacketBuffer buffer) {
        buffer.writeUnsignedVarInt(commandOrigin.type());
        buffer.writeUUID(commandOrigin.uuid());
        buffer.writeString(String.valueOf(commandOrigin.requestId()));

        if (commandOrigin.type() == CommandOrigin.ORIGIN_DEV_CONSOLE || commandOrigin.type() == CommandOrigin.ORIGIN_TEST) {
            buffer.writeSignedVarLong(commandOrigin.playerEntityUniqueId());
        }
    }

    public static Facing readBlockFace(PacketBuffer buffer) {
        int value = buffer.readSignedVarInt();
        return Things.convertFromDataToBlockFace((byte) value);
    }

    public static void writeBlockFace(Facing face, PacketBuffer buffer) {
        buffer.writeSignedVarInt(Objects.requireNonNull(Things.convertBlockFaceToData(face)));
    }

    void writeByteRotation(float rotation, PacketBuffer buffer) {
        buffer.writeByte((byte) (rotation / BYTE_ROTATION_DIVIDOR));
    }

    float readByteRotation(PacketBuffer buffer) {
        return buffer.readByte() * BYTE_ROTATION_DIVIDOR;
    }

    public void serializeHeader(PacketBuffer buffer) {
        buffer.writeUnsignedVarInt(this.id);
    }

    @Override
    public String toString() {
        return "Packet{" +
            "id=" + this.id +
            '}';
    }

}
