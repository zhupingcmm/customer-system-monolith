package com.mf.outsouring.system.hangzhou.service;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import com.mf.outsouring.system.hangzhou.repository.HangzhouCustomerStaffRepository;
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
public class HangZhouCustomerStaffServiceImplTests {

    @MockBean
    private HangzhouCustomerStaffRepository repository;

    @Autowired
    private HangZhouCustomerStaffService customerStaffService;


    @Test
    public void testCreateCustomerStaff() {
        val id = 1L;

        val customerStaff = new HangZhouCustomerStaff()
                .setId(id)
                .setNickname("zp")
                .setGender("MALE")
                .setRemark("PP")
                .setAvatar("avatar")
                .setRemark("remark");
        Mockito.when(repository.save(customerStaff)).thenReturn(customerStaff);

        val staff = customerStaffService.createCustomerStaff(customerStaff);
        assertThat(staff).isNotNull();
        assertThat(staff.getId()).isEqualTo(1L);
    }
}
