package com.mf.ticket.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 工单服务本地客服人员表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("local_customer_staff")
public class LocalCustomerStaff extends BaseBean {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long staffId;
    private String staffName;
    private Long accountId;
    private String phone;
    private Date createTime;
    private Date updateTime;
}
