package service;

import domain.OutsourcingSystemDTO;

import java.util.List;

public interface CustomerStaffIntegrationService<T> {
    List<T> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystemDTO);
}
