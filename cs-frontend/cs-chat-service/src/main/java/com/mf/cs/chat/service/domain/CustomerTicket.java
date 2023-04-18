package com.mf.cs.chat.service.domain;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CustomerTicket extends BaseBean {


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

}
