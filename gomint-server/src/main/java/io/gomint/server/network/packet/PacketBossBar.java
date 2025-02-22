/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.network.packet;

import io.gomint.jraknet.PacketBuffer;
import io.gomint.server.network.Protocol;

/**
 * @author geNAZt
 * @version 1.0
 */
public class PacketBossBar extends Packet {

    private long entityId;
    private Type type;
    private long playerId;
    private float healthPercent;
    private String title = "";
    private boolean darkenScreen;
    private int color;
    private int overlay;

    /**
     * Construct a new packet
     */
    public PacketBossBar() {
        super(Protocol.PACKET_BOSS_BAR);
    }

    @Override
    public void serialize(PacketBuffer buffer, int protocolID) {
        buffer.writeSignedVarLong(this.entityId);
        buffer.writeUnsignedVarInt(this.type.getId());
        switch (this.type) {
            case SHOW:
                buffer.writeString(this.title);
                buffer.writeLFloat(this.healthPercent);
            case PROPERTIES:
                buffer.writeShort((short) (this.darkenScreen ? 1 : 0));
            case TEXTURE:
                buffer.writeUnsignedVarInt(this.color);
                buffer.writeUnsignedVarInt(this.overlay);
                break;
            case HEALTH_UPDATE:
                buffer.writeLFloat(this.healthPercent);
                break;
            case TITLE:
                buffer.writeString(this.title);
                break;
        }
    }

    @Override
    public void deserialize(PacketBuffer buffer, int protocolID) {

    }

    public long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public float getHealthPercent() {
        return this.healthPercent;
    }

    public void setHealthPercent(float healthPercent) {
        this.healthPercent = healthPercent;
    }

    public boolean isDarkenScreen() {
        return this.darkenScreen;
    }

    public void setDarkenScreen(boolean darkenScreen) {
        this.darkenScreen = darkenScreen;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getOverlay() {
        return this.overlay;
    }

    public void setOverlay(int overlay) {
        this.overlay = overlay;
    }

    public enum Type {
        SHOW(0),
        REGISTER_PLAYER(1),
        HIDE(2),
        UNREGISTER_PLAYER(3),
        HEALTH_UPDATE(4),
        TITLE(5),
        PROPERTIES(6),
        TEXTURE(7),
        QUERY(8);

        private final int id;

        Type(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }

}
