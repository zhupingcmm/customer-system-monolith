package com.mf.outsouring.system.beijing.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.mf.outsouring.system.beijing.entity.BeijingCustomerStaff;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@MybatisPlusTest
@AutoConfigureTestDatabase
public class BeijingCustomerStaffMapperTests {


    @Autowired
    private BeijingCustomerStaffMapper customerStaffMapper;

    @Test
    public void testCreateStaffAndGetById(){
        val customerStaff = new BeijingCustomerStaff()
                .setIsDeleted(false)
                .setAvatar("zp")
                .setGender("male")
                .setNickname("cppp")
                .setRemark("gg");
        int num = customerStaffMapper.insert(customerStaff);
        assertThat(num).isEqualTo(1);
    }
}
