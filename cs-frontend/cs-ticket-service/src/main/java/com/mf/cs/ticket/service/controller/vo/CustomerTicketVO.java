package com.mf.cs.ticket.service.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerTicketVO {

    private Long id;


    /**
     * 工单编号
     */
    private String ticketNo;

    /**
     * 工单咨询内容
     */
    private String inquire;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 客服人员Id
     */
    private Long staffId;

    /**
     * 工单状态，1：初始化，2：进行中，3：结束
     */
    private Integer status;

    /**
     * 工单评分
     */
    private Integer score;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
