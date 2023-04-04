package com.mf.cs.security.auth.server.controller.vo;

import com.mf.cs.security.auth.server.domain.PasswordEncoderType;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;

@Data
public class UserVO extends BaseBean {

    private Long id;

    private String username;

    private String password;

    private PasswordEncoderType passwordEncoderType;

    private String authorities;
}
