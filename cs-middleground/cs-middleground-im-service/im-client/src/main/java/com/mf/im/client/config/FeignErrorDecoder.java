package com.mf.im.client.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class FeignErrorDecoder extends ErrorDecoder.Default {

    @Override
    public Exception decode(String methodKey, Response response) {
        val exception = super.decode(methodKey, response);
        log.error(exception.getMessage(), exception);
        return exception;
    }
}
