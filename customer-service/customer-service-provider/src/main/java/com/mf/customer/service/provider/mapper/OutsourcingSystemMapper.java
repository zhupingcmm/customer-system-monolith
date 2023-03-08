package com.mf.customer.service.provider.mapper;


import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutsourcingSystemMapper {
    void addOutsourcingSystem(OutsourcingSystem outsourcingSystem);

    OutsourcingSystem findOutsourcingSystemById(Long systemId);

    int deleteBySystemId(Long systemId);
}
