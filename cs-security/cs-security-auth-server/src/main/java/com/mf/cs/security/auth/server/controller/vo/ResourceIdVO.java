package com.mf.cs.security.auth.server.controller.vo;

import lombok.Data;

import javax.persistence.*;

@Data
public class ResourceIdVO {

    private Long id;

    private String name;

    private Long clientDetailId;
}
