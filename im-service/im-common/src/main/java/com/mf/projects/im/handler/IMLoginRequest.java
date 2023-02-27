package com.mf.projects.im.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IMLoginRequest {

    private String userId;
    private String userName;
    private String password;
    private String serverHost;
    private int nettyPort;
    private int httpPort;
}
