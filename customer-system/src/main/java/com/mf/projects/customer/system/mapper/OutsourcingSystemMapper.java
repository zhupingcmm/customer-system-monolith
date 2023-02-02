package com.mf.projects.customer.system.mapper;

import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutsourcingSystemMapper {
    void addOutsourcingSystem(OutsourcingSystem outsourcingSystem);

    OutsourcingSystem findOutsourcingSystemById(Long systemId);
}
