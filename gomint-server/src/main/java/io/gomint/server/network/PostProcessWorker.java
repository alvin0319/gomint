package io.gomint.server.network;

import io.gomint.jraknet.PacketBuffer;
import io.gomint.server.maintenance.ReportUploader;
import io.gomint.server.network.packet.Packet;
import io.gomint.server.network.packet.PacketBatch;
import io.netty.buffer.ByteBuf;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
public class PostProcessWorker implements Runnable {

    private static final byte[] STATIC_VARINT = new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x0};
    private static final Logger LOGGER = LoggerFactory.getLogger(PostProcessWorker.class);

    private final ConnectionWithState connection;
    private final Packet[] packets;
    private final Consumer<Void> callback;
    private PlayerConnectionState state;

    public PostProcessWorker(ConnectionWithState connection, Packet[] packets, Consumer<Void> callback, PlayerConnectionState state) {
        this.connection = connection;
        this.packets = packets;
        this.callback = callback;
        this.state = state;
    }

    @Override
    public void run() {
        ByteBuf inBuf = writePackets(this.packets);
        if (inBuf.readableBytes() == 0) {
            inBuf.release();
            return;
        }

        PacketBatch batch = new PacketBatch();
        batch.setPayload(this.state == PlayerConnectionState.NETWORK_SETTINGS ? inBuf : this.connection.outputProcessor().process(inBuf));
        this.connection.send(batch);

        if (this.callback != null) {
            this.callback.accept(null);
        }
    }

    private ByteBuf writePackets(Packet[] packets) {
        // Write all packets into the inBuf for compression
        PacketBuffer buffer = new PacketBuffer(packets.length * 5 + (packets.length * 32));
        int currentPosition; // We start at 5 because of the first varint header

        for (Packet packet : packets) {
            // CHECKSTYLE:OFF
            try {
                // We write 4 0x80 and one 0x0 at the end to always result in 0 to have static sized "var" int
                int lengthPosition = buffer.getWritePosition();
                buffer.writeBytes(STATIC_VARINT);

                currentPosition = buffer.getWritePosition();

                packet.serializeHeader(buffer);
                packet.serialize(buffer, this.connection.protocolID());

                int writtenBytes = buffer.getWritePosition() - currentPosition;
                writeVarInt(lengthPosition, writtenBytes, buffer.getBuffer());
            } catch (Exception e) {
                LOGGER.error("Could not serialize packet", e);
                ReportUploader.create().tag("network.serialize").exception(e).upload();
            }
            // CHECKSTYLE:ON
        }

        return buffer.getBuffer();
    }

    private void writeVarInt(int start, int value, ByteBuf stream) {
        int current = start;

        while ((value & -128) != 0) {
            stream.setByte(current++, value & 0x7F | 0x80);
            value >>>= 7;
        }

        stream.setByte(current, value | 0x80);
    }

}
