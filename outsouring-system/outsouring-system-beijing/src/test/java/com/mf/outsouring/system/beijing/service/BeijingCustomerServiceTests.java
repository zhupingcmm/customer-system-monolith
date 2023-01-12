package com.mf.outsouring.system.beijing.service;

import com.mf.outsouring.system.beijing.entity.BeijingCustomerStaff;
import com.mf.outsouring.system.beijing.mapper.BeijingCustomerStaffMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BeijingCustomerServiceTests {

    @MockBean
    private BeijingCustomerStaffMapper beijingCustomerStaffMapper;

    @Autowired
    private BeijingCustomerService beijingCustomerService;

    @Test
    public void testCreateBeijingCustomerSystemStaff(){
        val customerStaff = new BeijingCustomerStaff()
                .setIsDeleted(false)
                .setAvatar("zp")
                .setGender("male")
                .setNickname("cppp")
                .setRemark("gg");

        Mockito.when(beijingCustomerStaffMapper.insert(customerStaff)).thenReturn(1);
        val num = beijingCustomerService.createCustomerStaff(customerStaff);
        assertThat(num).isEqualTo(true);
    }


}
