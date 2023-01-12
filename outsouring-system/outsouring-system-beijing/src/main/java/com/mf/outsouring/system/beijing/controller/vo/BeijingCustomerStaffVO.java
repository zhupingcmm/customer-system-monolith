package com.mf.outsouring.system.beijing.controller.vo;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BeijingCustomerStaffVO extends BaseBean {
    private Long id;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private String goodAt;

    private String remark;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDeleted;
}
