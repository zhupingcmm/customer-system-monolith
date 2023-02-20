package service;

import domain.OutsourcingSystemDTO;

import java.util.List;

public interface CustomerStaffIntegrationService<T> {
    List<T> fetchCustomerStaffs(Integer currentPage, Integer pageSize, OutsourcingSystemDTO outsourcingSystemDTO);

    Long getCustomerStaffCount(OutsourcingSystemDTO outsourcingSystemDTO);
}
