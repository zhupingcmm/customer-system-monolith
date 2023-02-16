package com.mf.integration.service.provider.servicebus.router.hangzhou.dto;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors
public class HangzhouCustomerStaff extends BaseBean {
    private Long id;
    private String nickname;
    private String avatar;
    private String phone;
    private String gender;
    private String goodAt;
    private String remark;
    private Boolean isDeleted;
    private Date createAt;
    private Date updateAt;
}