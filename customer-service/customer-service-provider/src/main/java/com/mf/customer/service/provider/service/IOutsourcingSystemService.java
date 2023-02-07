package com.mf.customer.service.provider.service;


import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;

public interface IOutsourcingSystemService {

    void addOutsourcingSystem(OutsourcingSystem outsourcingSystem);

    OutsourcingSystem findOutsourcingSystemById(Long systemId);

}
