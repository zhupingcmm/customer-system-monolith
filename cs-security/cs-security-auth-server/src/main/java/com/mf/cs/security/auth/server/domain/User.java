package com.mf.cs.security.auth.server.domain;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private PasswordEncoderType passwordEncoderType;

    private String authorities;

}
