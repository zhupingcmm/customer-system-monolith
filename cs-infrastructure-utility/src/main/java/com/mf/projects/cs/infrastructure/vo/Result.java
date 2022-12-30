package com.mf.projects.cs.infrastructure.vo;

import com.mf.projects.cs.infrastructure.exception.MessageCode;
import lombok.Data;
import lombok.ToString;
import org.slf4j.MDC;

@ToString
@Data
public class Result<T> {

    public final static String TRACE_LOG_ID = "traceId";

    private int status;

    private String message;

    private T data;

    private String traceId;

    private String errMsg;

    public Result() {
    }



    public Result(int status, String message, String traceId) {
        this.status = status;
        this.message = message;
        this.traceId = traceId;
    }



    public Result(int status, String message, T data, String traceId) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.traceId = traceId;
    }

    public boolean rsIsOk() {
        return status == MessageCode.SUCCESS.getStatus();
    }

    public static Result success() {
        return new Result(MessageCode.SUCCESS.getStatus(), MessageCode.SUCCESS.getMessage(), MDC.get(TRACE_LOG_ID));
    }

    public static Result success(MessageCode  messageCode) {
        return new Result(messageCode.getStatus(), messageCode.getMessage(), MDC.get(TRACE_LOG_ID));
    }

    public static <T> Result success(T data) {
        return new Result(MessageCode.SUCCESS.getStatus(), MessageCode.SUCCESS.getMessage(), data, MDC.get(TRACE_LOG_ID));
    }

    public static <T> Result success(int code, String message, T data) {
        return new Result(code, message, data, MDC.get(TRACE_LOG_ID));
    }


    public static Result error() {
        return new Result(MessageCode.SYSTEM_ERROR.getStatus(), MessageCode.SYSTEM_ERROR.getMessage(), MDC.get(TRACE_LOG_ID));
    }

    public static Result error(int code, String message) {
        return new Result(code, message, MDC.get(TRACE_LOG_ID));
    }

    public static Result error(String message) {
        return new Result(MessageCode.SYSTEM_ERROR.getStatus(), message, MDC.get(TRACE_LOG_ID));
    }

    public static <T> Result error(String message, T data) {
        return new Result(MessageCode.SYSTEM_ERROR.getStatus(), message, data, MDC.get(TRACE_LOG_ID));
    }

    public static <T> Result error(int code, String message, T data) {
        return new Result(code, message, data, MDC.get(TRACE_LOG_ID));
    }



}
