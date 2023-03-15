package com.mf.ticket.service.service.impl;

import com.mf.ticket.service.entity.LocalCustomerStaff;
import com.mf.ticket.service.service.LocalCustomerStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Primary
@Service(value = "redis_local_customer")
public class LocalCustomerStaffRedisServiceImpl implements LocalCustomerStaffService {

    private static final String KET_PRE_FIX = "local::customer::";

    @Autowired
    private RedisTemplate<String, LocalCustomerStaff> redisTemplate;

    @Override
    public void insertLocalCustomerStaff(LocalCustomerStaff localCustomerStaff) {
        redisTemplate.opsForValue().set(getKey(localCustomerStaff), localCustomerStaff);
    }

    @Override
    public void updateLocalCustomerStaff(LocalCustomerStaff localCustomerStaff) {
        redisTemplate.opsForValue().set(getKey(localCustomerStaff), localCustomerStaff);
    }

    @Override
    public void deleteLocalCustomerStaff(LocalCustomerStaff localCustomerStaff) {
        redisTemplate.delete(getKey(localCustomerStaff));
    }

    @Override
    public LocalCustomerStaff findLocalCustomerStaffByStaffId(Long staffId) {
        return redisTemplate.opsForValue().get(KET_PRE_FIX + staffId);
    }

    private String getKey (LocalCustomerStaff localCustomerStaff) {
        return KET_PRE_FIX + localCustomerStaff.getStaffId();
    }
}
