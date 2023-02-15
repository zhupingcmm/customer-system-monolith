package com.mf.projects.im.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class P2PChatRequest implements Serializable {
    private String fromUserId;
    private String toUserId;
    private String msg;
}
