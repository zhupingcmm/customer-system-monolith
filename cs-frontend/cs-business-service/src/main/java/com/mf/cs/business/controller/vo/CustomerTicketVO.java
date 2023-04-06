package com.mf.cs.business.controller.vo;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerTicketVO extends BaseBean {

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
