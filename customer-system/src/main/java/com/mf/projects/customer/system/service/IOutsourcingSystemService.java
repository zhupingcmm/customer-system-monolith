package com.mf.projects.customer.system.service;

import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;

public interface IOutsourcingSystemService {

    void addOutsourcingSystem(OutsourcingSystem outsourcingSystem);

    OutsourcingSystem findOutsourcingSystemById(Long systemId);

}
