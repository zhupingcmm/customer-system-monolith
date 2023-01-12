package com.mf.outsouring.system.beijing.converter;

import com.mf.outsouring.system.beijing.controller.vo.BeijingCustomerStaffVO;
import com.mf.outsouring.system.beijing.entity.BeijingCustomerStaff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeijingCustomerStaffConverter {
    BeijingCustomerStaffConverter INSTANCE = Mappers.getMapper(BeijingCustomerStaffConverter.class);

    // vo -> entity
    BeijingCustomerStaff convertToEntity(BeijingCustomerStaffVO customerStaffVO);

    // entity -> vo
    List<BeijingCustomerStaffVO> convertToVOList(List<BeijingCustomerStaff> list);
}
