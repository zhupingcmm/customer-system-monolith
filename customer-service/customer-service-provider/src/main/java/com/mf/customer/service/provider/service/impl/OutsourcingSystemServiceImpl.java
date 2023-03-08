package com.mf.customer.service.provider.service.impl;



import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
import com.mf.customer.service.provider.mapper.OutsourcingSystemMapper;
import com.mf.customer.service.provider.service.IOutsourcingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OutsourcingSystemServiceImpl implements IOutsourcingSystemService {

    @Autowired
    private OutsourcingSystemMapper outsourcingSystemMapper;


    @Override
    @CachePut(cacheNames = {"os"}, key = "#outsourcingSystem.appId")
    public OutsourcingSystem addOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        outsourcingSystemMapper.addOutsourcingSystem(outsourcingSystem);
        return outsourcingSystem;
    }


    @Override
    @Cacheable(cacheNames = {"os"}, key = "#systemId")
    public OutsourcingSystem findOutsourcingSystemById(Long systemId) {
        return outsourcingSystemMapper.findOutsourcingSystemById(systemId);
    }

    @Override
    @CacheEvict(cacheNames = {"os"}, key = "#systemId")
    public void deleteBySystemId(Long systemId) {
        outsourcingSystemMapper.deleteBySystemId(systemId);
    }

}
