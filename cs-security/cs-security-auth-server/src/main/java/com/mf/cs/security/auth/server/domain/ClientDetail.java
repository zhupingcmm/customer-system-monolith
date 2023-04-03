package com.mf.cs.security.auth.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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

    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @Column(name = "auto_approve")
    private Boolean autoApprove;

    @OneToMany (targetEntity = ResourceId.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Set<ResourceId> resourceIds;

    @OneToMany (targetEntity = Scope.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Set<Scope> scope;

    @OneToMany (targetEntity = AuthorizedGrantType.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Set<AuthorizedGrantType> authorizedGrantTypes;

    @OneToMany (targetEntity = WebServerRedirectUri.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Set<WebServerRedirectUri> redirectUri;

}
