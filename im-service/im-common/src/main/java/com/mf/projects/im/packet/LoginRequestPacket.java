package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Command;
import com.mf.projects.im.protocol.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestPacket extends Packet {

    private String userId;
    private String userName;
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
