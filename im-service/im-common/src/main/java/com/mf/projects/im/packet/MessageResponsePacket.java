package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;
import lombok.Data;

@Data
public class MessageResponsePacket extends BaseResponsePacket{
    /**
     *
     */
    private String fromUserId;

    private String fromUserName;


    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
