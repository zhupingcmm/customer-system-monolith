package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;
import com.mf.projects.im.protocol.Packet;
import lombok.Data;

@Data
public class HeartBeatPacket extends Packet {
    private String msg = "heart-beat";

    @Override
    public Byte getCommand() {
        return Command.HEART_BEAT;
    }
}
