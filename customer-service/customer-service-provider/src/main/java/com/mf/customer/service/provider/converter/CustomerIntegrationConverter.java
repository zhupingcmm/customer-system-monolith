package com.mf.customer.service.provider.converter;

import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import domain.OutsourcingSystemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerIntegrationConverter {
    CustomerIntegrationConverter INSTANCE = Mappers.getMapper(CustomerIntegrationConverter.class);

    //DTO->Entity
    List<CustomerStaff> convertCustomerStaffListDTO(List<PlatformCustomerStaff> staffs);

    CustomerStaff convertToCustomerStaff(PlatformCustomerStaff platformCustomerStaff);


    // ENTITY -> DTO
    OutsourcingSystemDTO convertToDto(OutsourcingSystem entity);
}
