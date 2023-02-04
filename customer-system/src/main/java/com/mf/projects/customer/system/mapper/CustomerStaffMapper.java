package com.mf.projects.customer.system.mapper;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerStaffMapper {
    List<CustomerStaff> findCustomerStaffs(@Param("start") Long start, @Param("offset") Long offset);

    List<CustomerStaff> findAllCustomerStaffs();

    List<CustomerStaff> findCustomerStaffsByName(@Param("staffName") String staffName, @Param("start") Long start, @Param("offset") Long offset);

    CustomerStaff findCustomerStaffById(Long staffId);

    int createCustomerStaff(CustomerStaff customerStaff);

    int createCustomerStaffs(@Param("customerStaffs") List<CustomerStaff> customerStaffs);

    int updateCustomerStaff(CustomerStaff customerStaff);

    int deleteCustomerStaffById(Long staffId);

}
