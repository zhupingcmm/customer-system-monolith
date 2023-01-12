package com.mf.outsouring.system.beijing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("beijing_customer_staff")
public class BeijingCustomerStaff extends BaseBean {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private String goodAt;

    private String remark;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDeleted;

}
