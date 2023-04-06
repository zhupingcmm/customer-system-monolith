package com.mf.cs.chat.service.controller.vo;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatRecordVO extends BaseBean {
    private Long id;

    private String ticketNo;


    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 客服人员Id
     */
    private Long staffId;

    /**
     * 最新一条消息
     */
    private String lastMessage;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
