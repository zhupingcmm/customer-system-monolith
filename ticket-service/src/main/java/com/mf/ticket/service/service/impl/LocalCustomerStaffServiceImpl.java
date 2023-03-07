package com.mf.ticket.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.ticket.service.entity.LocalCustomerStaff;
import com.mf.ticket.service.mapper.LocalCustomerStaffMapper;
import com.mf.ticket.service.service.LocalCustomerStaffService;
import org.springframework.stereotype.Service;

@Service
public class LocalCustomerStaffServiceImpl extends ServiceImpl<LocalCustomerStaffMapper, LocalCustomerStaff> implements LocalCustomerStaffService {

    @Override
    public void insertLocalCustomerStaff(LocalCustomerStaff localCustomerStaff) {
        baseMapper.insert(localCustomerStaff);
    }

    @Override
    public void updateLocalCustomerStaff(LocalCustomerStaff localCustomerStaff) {
        baseMapper.updateLocalCustomerStaffByStaffId(localCustomerStaff);
    }

    @Override
    public void deleteLocalCustomerStaff(LocalCustomerStaff localCustomerStaff) {
        baseMapper.delByStaffId(localCustomerStaff);
    }

    @Override
    public LocalCustomerStaff findLocalCustomerStaffByStaffId(Long staffId) {
        return baseMapper.findLocalCustomerStaffByStaffId(staffId);
    }
}
