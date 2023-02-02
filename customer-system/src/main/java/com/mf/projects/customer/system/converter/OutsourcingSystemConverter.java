package com.mf.projects.customer.system.converter;

import com.mf.projects.customer.system.controller.vo.CustomerStaffVO;
import com.mf.projects.customer.system.controller.vo.OutsourcingSystemVO;
import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OutsourcingSystemConverter {

    OutsourcingSystemConverter INSTANCE = Mappers.getMapper(OutsourcingSystemConverter.class);

    // VO -> ENTITY
    OutsourcingSystem convertToEntity(OutsourcingSystemVO vo);

    // ENTITY -> VO
    OutsourcingSystem convertToVO(OutsourcingSystem entity);

    // list ENTITY -> list VO
    List<OutsourcingSystemVO> convertToVOs(List<OutsourcingSystem> outsourcingSystems);
}
