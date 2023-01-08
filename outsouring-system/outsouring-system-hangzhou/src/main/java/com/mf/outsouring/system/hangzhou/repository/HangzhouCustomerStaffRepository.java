package com.mf.outsouring.system.hangzhou.repository;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HangzhouCustomerStaffRepository extends JpaRepository<HangZhouCustomerStaff, Long> {

    List<HangZhouCustomerStaff> findByIsDeletedFalse();

    List<HangZhouCustomerStaff> findByUpdateAtAfter(Date updateTime);

}
