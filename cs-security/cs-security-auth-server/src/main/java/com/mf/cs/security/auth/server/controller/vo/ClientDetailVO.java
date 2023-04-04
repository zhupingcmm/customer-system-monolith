package com.mf.cs.security.auth.server.controller.vo;

import lombok.Data;

@Data
public class ClientDetailVO {
    private Long id;

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String authorizedGrantTypes;

    private String webServerRedirectUris;


    private String authorities;

    private String autoApprove;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String scope;

}
