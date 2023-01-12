package com.mf.outsouring.system.beijing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.outsouring.system.beijing.entity.BeijingCustomerStaff;
import com.mf.outsouring.system.beijing.mapper.BeijingCustomerStaffMapper;
import com.mf.outsouring.system.beijing.service.BeijingCustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeijingCustomerServiceImpl extends ServiceImpl<BeijingCustomerStaffMapper, BeijingCustomerStaff> implements BeijingCustomerService {
    @Override
    public List<BeijingCustomerStaff> findAllCustomerStaffs() {
        LambdaQueryWrapper<BeijingCustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<BeijingCustomerStaff> findCustomerStaffsByUpdatedTime(Long updatedTime) {
        LambdaQueryWrapper<BeijingCustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BeijingCustomerStaff::getUpdatedAt, updatedTime);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean createCustomerStaff(BeijingCustomerStaff customerStaff) {
        return this.save(customerStaff);
    }

    @Override
    public Boolean updateCustomerStaff(BeijingCustomerStaff customerStaff) {
        return this.updateById(customerStaff);
    }

    @Override
    public Boolean deleteCustomerStaffById(Long id) {
        BeijingCustomerStaff customerStaff = new BeijingCustomerStaff();
        customerStaff.setIsDeleted(true);
        customerStaff.setId(id);
        return this.updateById(customerStaff);
//        return this.removeById(id);
    }
}
