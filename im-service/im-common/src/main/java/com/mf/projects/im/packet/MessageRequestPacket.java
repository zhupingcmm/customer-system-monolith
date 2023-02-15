package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;
import com.mf.projects.im.protocol.Packet;
import lombok.Data;

@Data
public class MessageRequestPacket extends Packet {

    /**
     * 消息内容
     */
    private String message;


    /**
     * 消息接受者
     */
    private String toUserId;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
