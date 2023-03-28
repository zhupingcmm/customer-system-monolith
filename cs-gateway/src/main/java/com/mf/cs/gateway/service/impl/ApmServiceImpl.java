package com.mf.cs.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.cs.gateway.entity.ApmRecord;
import com.mf.cs.gateway.mapper.ApmMapper;
import com.mf.cs.gateway.service.ApmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApmServiceImpl extends ServiceImpl<ApmMapper, ApmRecord> implements ApmService {
    @Override
    public void addRecord(ApmRecord apmRecord) {
        baseMapper.insert(apmRecord);
    }

    @Override
    public List<ApmRecord> getRecords(long pageSize, long currentPage) {
       return baseMapper.getApmRecords(pageSize, currentPage);
    }
}
