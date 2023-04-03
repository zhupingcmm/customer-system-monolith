package com.mf.cs.security.auth.server.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "web_server_redirect_uri")
public class WebServerRedirectUri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "client_id")
    private Long clientDetailId;
}
