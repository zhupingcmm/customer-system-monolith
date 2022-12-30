package com.mf.projects.customer.system.controller.vo;

import com.mf.projects.customer.system.entity.staff.enums.Gender;
import com.mf.projects.customer.system.entity.staff.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomerStaffVO {
    private Long groupId;
    private String nickname;
    private String accountId;
    private String staffName;
    private String avatar;
    private String phone;
    private Gender gender;
    private Status status;
    private String goodAt;
    private String welcomeMessage;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
