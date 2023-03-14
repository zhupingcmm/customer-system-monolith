package com.mf.customer.service.provider.controller.vo;


import com.mf.projects.cs.infrastructure.base.enums.Gender;
import com.mf.projects.cs.infrastructure.base.enums.Status;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CustomerStaffVO {
    private Long id;
    private Long groupId;
    private String nickname;
    private String accountId;
    private String staffName;
    private String avatar;
    private String phone;
    private Gender gender;
    private Status status;
    private String goodAt;
    private Boolean isAutoReply;
    private String welcomeMessage;
    private String remark;
    private Boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
