package com.mf.projects.cs.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class MessageCode {

    private int status;

    private String message;

    public static final MessageCode SUCCESS = MessageCode.build(200, "ok");

    public static final MessageCode UN_KNOW = MessageCode.build(10001, "unKnowError");

    public static final MessageCode SYSTEM_ERROR = MessageCode.build(10002, "systemError");

    public static final MessageCode COMPONENT_ERROR = MessageCode.build(10003, "componentError");

    public static final MessageCode RUNTIME_ERROR = MessageCode.build(10004, "runTimeError");

    /**
     * 远程调用错误
     */
    public static final MessageCode REMOTE_ERROR = MessageCode.build(10005, "callRemoteError");


    /**
     *
     */
    public static final MessageCode CHECK_ERROR = MessageCode.build(11000, "校验失败:{0}");



    public static MessageCode build(int status, String message) {
        return new MessageCode(status, message);
    }

}
