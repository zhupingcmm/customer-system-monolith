package com.mf.cs.security.auth.server.controller.vo;

import com.mf.cs.security.auth.server.domain.Authority;
import com.mf.cs.security.auth.server.domain.PasswordEncoderType;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
public class UserVO extends BaseBean {

    private Long id;

    private String username;

    private String password;

    private PasswordEncoderType passwordEncoderType;

    private List<Authority> authorities;
}
