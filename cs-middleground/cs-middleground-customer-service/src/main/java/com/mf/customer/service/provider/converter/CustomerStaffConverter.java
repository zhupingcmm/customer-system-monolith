package com.mf.customer.service.provider.converter;


import com.mf.customer.service.provider.controller.vo.CustomerStaffVO;
import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerStaffConverter {

    CustomerStaffConverter INSTANCE = Mappers.getMapper(CustomerStaffConverter.class);

    // VO - ENTITY
    CustomerStaff covertToEntity(PlatformCustomerStaff platformCustomerStaff);

    // ENTITY - VO
    CustomerStaffVO covertToVO(CustomerStaff customerStaff);

    List<CustomerStaffVO> covertToVOs(List<CustomerStaff> customerStaffs);
}
