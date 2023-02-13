package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;

public class LoginResponsePacket extends BaseResponsePacket{
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
