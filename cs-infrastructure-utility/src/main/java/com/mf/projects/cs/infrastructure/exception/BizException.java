package com.mf.projects.cs.infrastructure.exception;

public class BizException extends RuntimeException{

    private MessageCode messageCode;
    private String errorMessage;

    public BizException(MessageCode messageCode, String errorMessage) {
        super(messageCode.getMessage());
        this.messageCode = messageCode;
        this.errorMessage = errorMessage;
    }


    public BizException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
