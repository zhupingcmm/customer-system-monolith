package com.mf.ticket.service.listener.dto;

import lombok.Data;

@Data
public class CustomerStaffEventDTO {

    private Long id;
    private String staffName;
    private Long accountId;
    private String phone;
}
