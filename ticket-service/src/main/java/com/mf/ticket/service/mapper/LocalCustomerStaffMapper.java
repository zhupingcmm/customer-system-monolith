package com.mf.ticket.service.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mf.ticket.service.entity.LocalCustomerStaff;

public interface LocalCustomerStaffMapper extends BaseMapper<LocalCustomerStaff> {
    default LocalCustomerStaff findLocalCustomerStaffByStaffId(Long staffId){
        LambdaQueryWrapper<LocalCustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LocalCustomerStaff::getStaffId, staffId);
        return  selectOne(queryWrapper);
    }
}
