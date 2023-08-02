package io.gomint.server.network.handler;

import io.gomint.server.network.PlayerConnection;
import io.gomint.server.network.packet.PacketRespawnPosition;
import io.gomint.server.network.packet.PacketRespawnPosition.RespawnState;

/**
 * @author HerryYT
 * @version 1.0
 */
public class PacketRespawnPositionHandler implements PacketHandler<PacketRespawnPosition> {

    @Override
    public void handle(PacketRespawnPosition packet, long currentTimeMillis, PlayerConnection connection) {
        // Client ready
        if (packet.getState() == RespawnState.CLIENT_READY_TO_SPAWN) {
            PacketRespawnPosition packetRespawnPosition = new PacketRespawnPosition();
            packetRespawnPosition.setPosition(connection.entity().spawnLocation().add(0, connection.entity().eyeHeight(), 0));
            packetRespawnPosition.setEntityId(connection.entity().id());
            packetRespawnPosition.setState(RespawnState.READY_TO_SPAWN);
            connection.addToSendQueue(packetRespawnPosition);
        }
    }
}
