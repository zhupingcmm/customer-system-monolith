package com.mf.ticket.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 客服工单表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_ticket")
public class CustomerTicket extends BaseBean {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
