package com.mf.projects.customer.system.mapper;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerStaffMapper {
//    List<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex);
//
//    List<CustomerStaff> findCustomerStaffs();
//
//    List<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex);

    CustomerStaff findCustomerStaffById(Long staffId);

    int createCustomerStaff(CustomerStaff customerStaff);

//    int updateCustomerStaff(CustomerStaff customerStaff);
//
//    int deleteCustomerStaffById(Long staffId);
//
//    void syncOutsourcingCustomerStaffsBySystemId(Long systemId);
}
