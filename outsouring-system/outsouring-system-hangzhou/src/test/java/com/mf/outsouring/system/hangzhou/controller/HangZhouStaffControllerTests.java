package com.mf.outsouring.system.hangzhou.controller;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import com.mf.outsouring.system.hangzhou.service.HangZhouCustomerStaffService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HangZhouStaffControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HangZhouCustomerStaffService customerStaffService;

    @Test
    public void testCreateCustomerStaff() throws Exception {
        val id = 1L;
        val customerStaff = new HangZhouCustomerStaff()
                .setId(id)
                .setNickname("zp")
                .setGender("MALE")
                .setRemark("PP")
                .setAvatar("avatar")
                .setIsDeleted(false)
                .setRemark("remark");


        given(customerStaffService.createCustomerStaff(customerStaff)).willReturn(customerStaff);
        mockMvc.perform(post("/customerstatffs/hangzhou/")
//                        .header(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"id\": 1,\n" +
                                "  \"nickname\": \"jingxiao\",\n" +
                                "  \"avatar\": \"4.jpg\",\n" +
                                "  \"phone\": \"13775569898\",\n" +
                                "  \"gender\": \"MALE\",\n" +
                                "  \"goodAt\": \"ac\",\n" +
                                "  \"remark\": \"remark\",\n" +
                                "  \"isDeleted\": false\n" +
                                "}")
                )
                .andExpect(status().isOk());
    }
}
