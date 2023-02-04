package com.mf.projects.customer.system.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OutsourcingSystemVO {
    private Long id;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 系统编码
     */
//    private String systemId;

    /**
     * 系统描述
     */
    private String description;

    /**
     * 系统访问URL
     */
    private String systemUrl;

    /**
     * 系统ID
     */

    private Long appId;

    /**
     * 系统公钥
     */

    private String appKey;

    /**
     * 系统私钥
     */

    private String appSecret;

    /**
     * 是否删除，1=删除,0=未删除
     */
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
