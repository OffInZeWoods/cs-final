package edu.bw.ecoover18.radio;

import com.google.common.io.Files;
import edu.bw.ecoover18.radio.net.SongPacket;
import io.github.writedan.ppl.PPL;
import io.github.writedan.ppl.PPLServer;
import io.github.writedan.ppl.SocketListener;
import io.github.writedan.ppl.packet.Packet;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class PlaylistManager {
	private ArrayList<String> playlist;
	private AirwaveManager awManager = new AirwaveManager();
    private PPLServer pplServer = new PPLServer();

    public PlaylistManager(int port) throws Exception {
        pplServer.bind(port);
        pplServer.addListener(new SocketListener() {
            @Override
            public void connect(SocketChannel socketChannel) throws Exception {
                System.out.println("Connected on " + socketChannel.getLocalAddress());
            }

            @Override
            public void read(SocketChannel socketChannel, ByteBuffer byteBuffer) throws Exception {
                Packet p = PPL.decode(byteBuffer);
                if (p instanceof SongPacket) {
                    SongPacket songPacket = (SongPacket) p;
                    byte[] songData = songPacket.songData;
                    File randomFile = File.createTempFile("cs-final", null);
                    Files.write(songData, randomFile);
                    awManager.sendToAirwave(randomFile.getAbsolutePath());
                }
            }

            @Override
            public void exception(SocketChannel socketChannel, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
	}
}

