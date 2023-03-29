package com.mf.cs.security.auth.server.controller.vo;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;

@Data
public class AuthorityVO extends BaseBean {
    private Long id;

    private String name;

    private Long userId;
}
