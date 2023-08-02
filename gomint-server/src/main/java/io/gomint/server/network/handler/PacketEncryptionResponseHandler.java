/*
 *  Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 *  This code is licensed under the BSD license found in the
 *  LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.network.handler;

import io.gomint.server.network.PlayerConnection;
import io.gomint.server.network.PlayerConnectionState;
import io.gomint.server.network.packet.PacketEncryptionResponse;
import io.gomint.server.network.packet.PacketNetworkSettings;
import io.gomint.server.network.packet.PacketPlayState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
public class PacketEncryptionResponseHandler implements PacketHandler<PacketEncryptionResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacketEncryptionResponseHandler.class);

    @Override
    public void handle(PacketEncryptionResponse packet, long currentTimeMillis, PlayerConnection connection) {
        connection.entity().loginPerformance().setEncryptionEnd(currentTimeMillis);

        LOGGER.info("We got encryption response: {}", connection.entity());

        PacketNetworkSettings networkSettings = new PacketNetworkSettings();
        networkSettings.setCompressionThreshold((short) 1);
        connection.addToSendQueue(networkSettings);

        connection.state(PlayerConnectionState.LOGIN);
        connection.sendPlayState(PacketPlayState.PlayState.LOGIN_SUCCESS);

        // Track performance
        connection.entity().loginPerformance().setResourceStart(currentTimeMillis);

        connection.initWorldAndResourceSend();
    }

}
