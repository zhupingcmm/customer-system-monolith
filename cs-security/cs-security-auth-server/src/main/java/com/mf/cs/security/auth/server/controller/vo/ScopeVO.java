package com.mf.cs.security.auth.server.controller.vo;

import lombok.Data;

import javax.persistence.*;

@Data
public class ScopeVO {

    private Long id;

    private String name;

    private Long clientDetailId;
}
