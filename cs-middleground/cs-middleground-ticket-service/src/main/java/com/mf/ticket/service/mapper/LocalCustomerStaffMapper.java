package com.mf.ticket.service.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mf.ticket.service.entity.LocalCustomerStaff;

public interface LocalCustomerStaffMapper extends BaseMapper<LocalCustomerStaff> {
    default LocalCustomerStaff findLocalCustomerStaffByStaffId(Long staffId){
        LambdaQueryWrapper<LocalCustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LocalCustomerStaff::getStaffId, staffId);
        return  selectOne(queryWrapper);
    }

    default void updateLocalCustomerStaffByStaffId(LocalCustomerStaff customerStaff) {
        LambdaUpdateWrapper<LocalCustomerStaff> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(LocalCustomerStaff::getStaffId, customerStaff.getStaffId());
        update(customerStaff, updateWrapper);
    }

    default void delByStaffId(LocalCustomerStaff localCustomerStaff) {
        LambdaQueryWrapper<LocalCustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LocalCustomerStaff::getStaffId, localCustomerStaff.getStaffId());
        delete(queryWrapper);

    }
}
