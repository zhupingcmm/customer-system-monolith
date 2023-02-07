package com.mf.customer.service.provider.service.impl;



import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
import com.mf.customer.service.provider.mapper.OutsourcingSystemMapper;
import com.mf.customer.service.provider.service.IOutsourcingSystemService;
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
