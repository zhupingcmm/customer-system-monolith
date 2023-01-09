package com.mf.outsouring.system.hangzhou.repository;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class HangzhouCustomerStaffRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HangzhouCustomerStaffRepository repository;


    @Test
    public void testCustomerStaffCreationAndQuery() {
        HangZhouCustomerStaff customerStaff = new HangZhouCustomerStaff();
        customerStaff.setIsDeleted(false);
        customerStaff.setCreateAt(new Date());
        customerStaff.setUpdateAt(new Date());
        customerStaff.setNickname("zp");
        customerStaff.setGender("male");
        this.entityManager.persist(customerStaff);

        val customerStaffs = repository.findByIsDeletedFalse();

        assertThat(customerStaffs).isNotNull();
        assertThat(customerStaffs.size()).isEqualTo(1);
    }


}
