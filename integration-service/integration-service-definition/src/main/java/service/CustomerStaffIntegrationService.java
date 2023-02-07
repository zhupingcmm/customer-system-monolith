package service;

import domain.OutsourcingSystemDTO;
import domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffIntegrationService {
    List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystemDTO);
}
