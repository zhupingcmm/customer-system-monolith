package com.mf.integration.service.provider.servicebus.transfomer.hangzhou;

import com.alibaba.fastjson.JSON;
import com.mf.integration.service.provider.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import com.mf.integration.service.provider.servicebus.transfomer.CustomerStaffTransformer;
import com.mf.projects.cs.infrastructure.base.enums.Gender;
import com.mf.projects.cs.infrastructure.base.enums.Status;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
@Service(value = "hangzhou_transformer")
public class HangzhouCustomerStaffTransformer implements CustomerStaffTransformer<HangzhouCustomerStaff> {
    @Override
    public List<PlatformCustomerStaff> transformCustomerStaffs(Long systemId, List<HangzhouCustomerStaff> staffs) {
        List<PlatformCustomerStaff> customerStaffs = new ArrayList<>();

        val hangzhouCustomerStaffs = JSON.parseArray(JSON.toJSONString(staffs), HangzhouCustomerStaff.class);

        hangzhouCustomerStaffs.forEach(staff -> {
            PlatformCustomerStaff customerStaff = transformerToPlatformCustomerStaff(systemId, staff);
            customerStaffs.add(customerStaff);

        });
        return customerStaffs;
    }

    private PlatformCustomerStaff transformerToPlatformCustomerStaff(Long systemId, HangzhouCustomerStaff staff) {
        PlatformCustomerStaff customerStaff = new PlatformCustomerStaff();
        customerStaff.setSystemId(systemId);
        customerStaff.setStaffName(staff.getNickname());
        customerStaff.setNickname(staff.getNickname());
        customerStaff.setAvatar(staff.getAvatar());
        customerStaff.setPhone(staff.getPhone());
        customerStaff.setGoodAt(staff.getGoodAt());
        customerStaff.setIsDeleted(staff.getIsDeleted());

        if (staff.getGender() != null) {
            customerStaff.setGender(Gender.valueOf(staff.getGender()));
        }


        if (staff.getCreateAt() != null) {
            ZoneId zone = ZoneId.systemDefault();
            Instant createdTimeInstance = staff.getCreateAt().toInstant();
            LocalDateTime createdTimeLocalDateTime = LocalDateTime.ofInstant(createdTimeInstance, zone);
            customerStaff.setCreateTime(createdTimeLocalDateTime);

        }

        if (staff.getUpdateAt() != null)  {
            ZoneId zone = ZoneId.systemDefault();
            Instant updatedTimeInstance = staff.getCreateAt().toInstant();
            LocalDateTime updatedTimeLocalDateTime = LocalDateTime.ofInstant(updatedTimeInstance, zone);
            customerStaff.setUpdateTime(updatedTimeLocalDateTime);
        }

        customerStaff.setAccountId(staff.getId());
        customerStaff.setStatus(Status.OFFLINE);
        return customerStaff;
    }

    @Override
    public PlatformCustomerStaff transformCustomerStaff(Long systemId, HangzhouCustomerStaff staff) {

        return transformerToPlatformCustomerStaff(systemId, staff);
    }
}
