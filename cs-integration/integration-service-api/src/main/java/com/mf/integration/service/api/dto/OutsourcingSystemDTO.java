package com.mf.integration.service.api.dto;


import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class OutsourcingSystemDTO extends BaseBean {
    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 系统编码
     */
    private String systemCode;

    /**
     * 系统描述
     */
    private String description;

    /**
     * 系统访问URL
     */
    private String systemUrl;

    /**
     * 系统 ID
     */
    private Long appId;
}
