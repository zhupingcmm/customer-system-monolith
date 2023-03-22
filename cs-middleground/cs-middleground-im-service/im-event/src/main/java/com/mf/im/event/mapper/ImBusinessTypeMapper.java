package com.mf.im.event.mapper;


import com.mf.im.event.entity.ImBusinessType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImBusinessTypeMapper {
    ImBusinessType findBusinessTypeByCode(@Param("businessTypeCode") String businessTypeCode);
}
