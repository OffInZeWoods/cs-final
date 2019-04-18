package edu.bw.ecoover18.radio.net;

import io.github.writedan.ppl.packet.Packet;
import io.github.writedan.ppl.packet.PacketData;
import io.github.writedan.ppl.packet.PacketField;
import io.github.writedan.ppl.packet.Serverside;

@PacketData(id = 0, desc = "Contains song names and WAV files to be broadcast", bound = Serverside.class)
public class SongPacket extends Packet {
    public @PacketField
    String songName;
    public @PacketField
    byte[] songData;
}
