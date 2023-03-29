package com.mf.cs.security.auth.server.domain;


import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

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

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "user_id"))
    private List<Authority> authorities;

}
