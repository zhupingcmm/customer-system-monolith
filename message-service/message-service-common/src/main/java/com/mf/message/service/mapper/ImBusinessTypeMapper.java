package com.mf.message.service.mapper;

import com.mf.message.service.entity.ImBusinessType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImBusinessTypeMapper {
    ImBusinessType findBusinessTypeByCode(@Param("businessTypeCode") String businessTypeCode);
}
