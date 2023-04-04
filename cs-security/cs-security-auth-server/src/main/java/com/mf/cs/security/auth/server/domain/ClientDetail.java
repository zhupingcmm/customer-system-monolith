package com.mf.cs.security.auth.server.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client_detail")
public class ClientDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "resource_ids")
    private String resourceIds;

    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uris")
    private String webServerRedirectUris;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "auto_approve")
    private String autoApprove;

    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    private String scope;

}
