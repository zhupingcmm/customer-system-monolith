package com.mf.outsouring.system.hangzhou.entity;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "hangzhou_customer_staff")
@DynamicUpdate
public class HangZhouCustomerStaff extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    @Column(name = "good_at")
    private String goodAt;

    private String remark;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Date updateAt;

    @CreatedDate
    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createAt;

}
