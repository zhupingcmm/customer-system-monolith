package com.mf.ticket.service.controller.vo;


import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TicketVO extends BaseBean {
    private String ticketNo;

    private Long userId;

    private Long staffId;

    private String inquire;
}
