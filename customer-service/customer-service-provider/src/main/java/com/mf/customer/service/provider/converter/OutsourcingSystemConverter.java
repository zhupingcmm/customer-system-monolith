package com.mf.customer.service.provider.converter;


import com.mf.customer.service.provider.controller.vo.OutsourcingSystemVO;
import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
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
