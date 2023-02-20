package com.mf.outsouring.system.hangzhou.converter;

import com.mf.outsouring.system.hangzhou.controller.vo.HangZhouCustomerStaffVO;
import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HangZhouCustomerStaffConverter {

    HangZhouCustomerStaffConverter INSTANCE = Mappers.getMapper(HangZhouCustomerStaffConverter.class);

    // ENTITY -> VO
    HangZhouCustomerStaffVO convertToVO(HangZhouCustomerStaff entity);
    List<HangZhouCustomerStaffVO> convertToListVO(List<HangZhouCustomerStaff> list);

    // VO -> ENTITY
    HangZhouCustomerStaff convertToEntity(HangZhouCustomerStaffVO vo);
    List<HangZhouCustomerStaff> convertToEntityList(List<HangZhouCustomerStaffVO> vos);

}
