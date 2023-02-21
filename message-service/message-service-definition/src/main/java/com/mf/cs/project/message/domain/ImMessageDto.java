package com.mf.cs.project.message.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ImMessageDto {
    private Long id;
    private Long fromUserId;
    private String fromUsername;
    private Long toUserId;
    private String toUsername;
    private String businessTypeCode;
    private String businessTypeName;
    private String message;
    private LocalDateTime createTime;
}
