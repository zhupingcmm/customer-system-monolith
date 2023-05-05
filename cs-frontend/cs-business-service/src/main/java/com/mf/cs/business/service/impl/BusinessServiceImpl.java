package com.mf.cs.business.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mf.cs.business.controller.vo.ChatRecordVO;
import com.mf.cs.business.controller.vo.CustomerTicketVO;
import com.mf.cs.business.feignclient.ChatRecordClient;
import com.mf.cs.business.feignclient.TicketClient;
import com.mf.cs.business.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private ChatRecordClient chatRecordClient;

    @Autowired
    private TicketClient ticketClient;

    @Override
    @GlobalTransactional
    public void generateTicket(CustomerTicketVO customerTicketVO) {
        ChatRecordVO chatRecordVO = new ChatRecordVO();
        chatRecordVO.setStaffId(customerTicketVO.getStaffId());
        chatRecordVO.setLastMessage("zp");
        chatRecordVO.setUserId(customerTicketVO.getUserId());
        chatRecordVO.setTicketNo("test");

        chatRecordClient.insertChatRecord(chatRecordVO);

        ticketClient.addTicket(customerTicketVO);
    }



}
