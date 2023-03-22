package com.mf.projects.im.dto;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;

import java.io.Serializable;


@Data
public class P2PChatRequest extends BaseBean {
    private String fromUserId;
    private String toUserId;
    private String msg;
}
