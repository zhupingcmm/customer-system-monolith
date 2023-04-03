package com.mf.cs.security.auth.server.controller.vo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
public class ClientDetailVO {
    private Long id;

    private String clientId;

    private Set<ResourceIdVO> resourceIds;

    private String clientSecret;

    private Set<ScopeVO> scope;

    private Set<AuthorizedGrantTypeVO> authorizedGrantTypes;

    private Set<WebServerRedirectUriVO> redirectUri;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private Boolean autoApprove;

}
