package com.mf.projects.customer.system.service.impl;

import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;
import com.mf.projects.customer.system.mapper.OutsourcingSystemMapper;
import com.mf.projects.customer.system.service.IOutsourcingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutsourcingSystemServiceImpl implements IOutsourcingSystemService {

    @Autowired
    private OutsourcingSystemMapper outsourcingSystemMapper;
    @Override
    public void addOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        outsourcingSystemMapper.addOutsourcingSystem(outsourcingSystem);

    }

    @Override
    public OutsourcingSystem findOutsourcingSystemById(Long systemId) {
        return outsourcingSystemMapper.findOutsourcingSystemById(systemId);
    }
}
