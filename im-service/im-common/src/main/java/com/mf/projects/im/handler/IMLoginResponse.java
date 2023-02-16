package com.mf.projects.im.handler;

import com.mf.projects.im.dto.BaseResponse;

public class IMLoginResponse extends BaseResponse {
    public boolean relogin(){
        return "2001".equals(this.getCode());
    }
}
