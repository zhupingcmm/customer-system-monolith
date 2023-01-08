package com.mf.outsouring.system.hangzhou.controller.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class HangZhouCustomerStaffVO {
    private Long id;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private String goodAt;

    private String remark;

    private Boolean isDeleted;

    private Date updateAt;

    private Date createAt;
}
