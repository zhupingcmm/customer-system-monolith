package com.mf.projects.cs.infrastructure.exception;

import lombok.*;


@ToString
public enum MessageCode {



    SUCCESS(200, "ok"),
    UN_KNOW(10001, "unKnowError"),
    SYSTEM_ERROR(10002, "systemError"),
    COMPONENT_ERROR(10003, "componentError"),
    RUNTIME_ERROR(10004, "runTimeError"),
    REMOTE_ERROR(10005, "callRemoteError"),
    CHECK_ERROR(11000, "校验失败:{0}");


    @Getter
    private int code;
    @Getter
    private String message;

    MessageCode(int code, String message){
        this.message = message;
        this.code = code;
    }

}
