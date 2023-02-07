package com.mf.customer.service.provider.converter;

import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
import domain.OutsourcingSystemDTO;
import domain.PlatformCustomerStaff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerIntegrationConverter {
    CustomerIntegrationConverter INSTANCE = Mappers.getMapper(CustomerIntegrationConverter.class);

    //DTO->Entity
    List<CustomerStaff> convertCustomerStaffListDTO(List<PlatformCustomerStaff> dtos);


    // ENTITY -> DTO
    OutsourcingSystemDTO convertToDto(OutsourcingSystem entity);
}
