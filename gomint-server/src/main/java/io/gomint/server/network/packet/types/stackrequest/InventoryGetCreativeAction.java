/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.network.packet.types.stackrequest;

import io.gomint.jraknet.PacketBuffer;

/**
 * @author geNAZt
 */
public class InventoryGetCreativeAction implements InventoryAction {

    private int creativeItemId;

    @Override
    public void deserialize(PacketBuffer buffer, int protocolID) throws Exception {
        this.creativeItemId = buffer.readUnsignedVarInt();
    }

    @Override
    public int weight() {
        return 11;
    }

    public int getCreativeItemId() {
        return this.creativeItemId;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"InventoryGetCreativeAction\", " +
            "\"creativeItemId\":\"" + this.creativeItemId + "\"" +
            "}";
    }

}
