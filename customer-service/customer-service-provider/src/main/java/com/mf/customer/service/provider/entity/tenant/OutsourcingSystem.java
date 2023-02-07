package com.mf.customer.service.provider.entity.tenant;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 客服外部系统
 * outsourcing_system
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OutsourcingSystem extends BaseBean {

    private Long id;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 系统编码
     */
//    private String systemCode;

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
