package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;

public class DefaultErrorPacket extends BaseResponsePacket{
    @Override
    public Byte getCommand() {
        return Command.DEFAULT_ERROR;
    }
}
