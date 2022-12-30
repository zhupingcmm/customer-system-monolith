package com.mf.projects.customer.system.converter;

import com.mf.projects.customer.system.controller.vo.CustomerStaffVO;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerStaffConverter {

    CustomerStaffConverter INSTANCE = Mappers.getMapper(CustomerStaffConverter.class);

    // VO - ENTITY
    CustomerStaff covertToEntity(CustomerStaffVO customerStaffVO);

    // ENTITY - VO
    CustomerStaffVO covertToVO(CustomerStaff customerStaff);

    List<CustomerStaffVO> covertToVOs(List<CustomerStaff> customerStaffs);
}
