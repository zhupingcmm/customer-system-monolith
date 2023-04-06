package com.mf.cs.chat.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@TableName("chat_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ChatRecord extends BaseBean {

    @TableId(value = "id", type = IdType.AUTO)
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
