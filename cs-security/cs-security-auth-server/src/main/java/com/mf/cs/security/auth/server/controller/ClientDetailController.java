package com.mf.cs.security.auth.server.controller;

import com.mf.cs.security.auth.server.controller.vo.ClientDetailVO;
import com.mf.cs.security.auth.server.converter.ClientDetailConverter;
import com.mf.cs.security.auth.server.service.CustomerClientDetailsService;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientDetailController {

    @Autowired
    private CustomerClientDetailsService clientDetailsService;

    @PostMapping
    Result<ClientDetailVO> addClientDetail(@RequestBody ClientDetailVO clientDetail) {
        val detail = clientDetailsService.addClient(ClientDetailConverter.INSTANCE.transToEntity(clientDetail));

        return Result.success(detail);
    }
}
