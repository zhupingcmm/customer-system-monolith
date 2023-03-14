package com.mf.projects.im.packet;

import com.mf.projects.im.protocol.Packet;
import lombok.Data;


@Data
public abstract class BaseResponsePacket  extends Packet {

    private String code = "0000";

    private String msg;

    public boolean success() {
        return "0000".equals(code);
    }
}
