package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;

public class LoginResponsePacket extends BaseResponsePacket{

    public boolean relogin(){
        return "2001".equals(this.getCode());
    }
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
