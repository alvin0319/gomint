package io.gomint.server.network.packet;

import io.gomint.jraknet.PacketBuffer;
import io.gomint.math.Vector;
import io.gomint.server.network.Protocol;
import io.gomint.server.world.SoundMagicNumbers;

/**
 * @author geNAZt
 * @version 1.0
 */
public class PacketWorldSoundEvent extends Packet implements PacketClientbound, PacketServerbound {

    private SoundMagicNumbers type;
    private Vector position;
    private int extraData = 0;
    private String entityId = ":";
    private boolean isBabyMob;
    private boolean disableRelativeVolume;

    public PacketWorldSoundEvent() {
        super(Protocol.PACKET_WORLD_SOUND_EVENT);
    }

    @Override
    public void serialize(PacketBuffer buffer, int protocolID) {
        buffer.writeUnsignedVarInt(this.type.soundId());
        buffer.writeLFloat(this.position.x());
        buffer.writeLFloat(this.position.y());
        buffer.writeLFloat(this.position.z());
        buffer.writeSignedVarInt(this.extraData);
        buffer.writeString(this.entityId);
        buffer.writeBoolean(this.isBabyMob);
        buffer.writeBoolean(this.disableRelativeVolume);
    }

    @Override
    public void deserialize(PacketBuffer buffer, int protocolID) {
        this.type = SoundMagicNumbers.valueOf(buffer.readUnsignedVarInt());
        this.position = new Vector(buffer.readLFloat(), buffer.readLFloat(), buffer.readLFloat());
        this.extraData = buffer.readSignedVarInt();
        this.entityId = buffer.readString();
        this.isBabyMob = buffer.readBoolean();
        this.disableRelativeVolume = buffer.readBoolean();
    }

    public SoundMagicNumbers getType() {
        return this.type;
    }

    public void setType(SoundMagicNumbers type) {
        this.type = type;
    }

    public Vector getPosition() {
        return this.position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public int getExtraData() {
        return this.extraData;
    }

    public void setExtraData(int extraData) {
        this.extraData = extraData;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public boolean isBabyMob() {
        return this.isBabyMob;
    }

    public void setBabyMob(boolean babyMob) {
        this.isBabyMob = babyMob;
    }

    public boolean isDisableRelativeVolume() {
        return this.disableRelativeVolume;
    }

    public void setDisableRelativeVolume(boolean disableRelativeVolume) {
        this.disableRelativeVolume = disableRelativeVolume;
    }
}
