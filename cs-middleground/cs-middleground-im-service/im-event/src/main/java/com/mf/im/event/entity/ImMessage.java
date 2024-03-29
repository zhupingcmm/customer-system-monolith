package com.mf.im.event.entity;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ImMessage extends BaseBean {

    private Long id;
    private Long fromUserId;
    private String fromUsername;
    private Long toUserId;
    private String toUsername;
    private String businessTypeCode;
    private String businessTypeName;
    private String message;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
