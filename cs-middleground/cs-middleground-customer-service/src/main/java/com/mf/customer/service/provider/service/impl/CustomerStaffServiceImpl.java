package com.mf.customer.service.provider.service.impl;



import com.mf.customer.service.provider.converter.CustomerIntegrationConverter;
import com.mf.customer.service.provider.converter.OutsourcingSystemConverter;
import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.customer.service.provider.event.CustomerStaffChangedEvent;
import com.mf.customer.service.provider.event.EventChangeService;
import com.mf.customer.service.provider.mapper.CustomerStaffMapper;
import com.mf.customer.service.provider.service.ICustomerStaffService;
import com.mf.customer.service.provider.service.IOutsourcingSystemService;
import com.mf.integration.service.api.feign.CustomerIntegrationServiceApi;
import com.mf.projects.cs.infrastructure.page.PageObject;
import event.Operation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerStaffServiceImpl implements ICustomerStaffService {

    private static final String EXCHANGE = "customer.service";
    private static final String ROTING_KEY = "customer.staff";

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    @Autowired
    private IOutsourcingSystemService outsourcingSystemService;

    @Autowired
    private EventChangeService<CustomerStaff> eventChangeService;

    @Autowired
    private CustomerIntegrationServiceApi customerIntegrationServiceApi;
    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        Long start = (pageIndex -1) * pageSize;

        val customerStaffs = customerStaffMapper.findCustomerStaffs(start, pageSize);
        return new PageObject<CustomerStaff>()
                .setTotal((long) customerStaffs.size())
                .setList(customerStaffs)
                .setPageIndex(pageIndex)
                .setPageSize(pageSize);
    }

    @Override
    public List<CustomerStaff> findCustomerStaffs() {
        return customerStaffMapper.findAllCustomerStaffs();
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex) {
        Long start = (pageIndex -1) * pageSize;
        val staffs = customerStaffMapper.findCustomerStaffsByName(staffName, start, pageSize);

        return new PageObject<CustomerStaff>()
                .setTotal((long) staffs.size())
                .setList(staffs)
                .setPageIndex(pageIndex)
                .setPageSize(pageSize);
    }

    @Override
    public CustomerStaff findCustomerStaffById(Long staffId) {
        return customerStaffMapper.findCustomerStaffById(staffId);
    }

    @Override
    public Boolean createCustomerStaff(CustomerStaff customerStaff) {
        customerStaffMapper.createCustomerStaff(customerStaff);

        CustomerStaffChangedEvent customerStaffChangedEvent = new CustomerStaffChangedEvent();
        customerStaffChangedEvent.setOperation(Operation.ADD);
        customerStaffChangedEvent.setMessage(customerStaff);
        eventChangeService.send(EXCHANGE, ROTING_KEY, customerStaffChangedEvent);
        return true;
    }

    @Override
    public Boolean updateCustomerStaff(CustomerStaff customerStaff) {
        customerStaffMapper.updateCustomerStaff(customerStaff);

        CustomerStaffChangedEvent customerStaffChangedEvent = new CustomerStaffChangedEvent();
        customerStaffChangedEvent.setOperation(Operation.UPDATE);
        customerStaffChangedEvent.setMessage(customerStaff);
        eventChangeService.send(EXCHANGE, ROTING_KEY, customerStaffChangedEvent);
        return true;
    }

    @Override
    public Boolean deleteCustomerStaffById(Long staffId) {
        val staff = customerStaffMapper.findCustomerStaffById(staffId);
        customerStaffMapper.deleteCustomerStaffById(staffId);

        if(staff != null) {
            CustomerStaffChangedEvent customerStaffChangedEvent = new CustomerStaffChangedEvent();
            customerStaffChangedEvent.setOperation(Operation.DELETE);
            customerStaffChangedEvent.setMessage(staff);

            eventChangeService.send(EXCHANGE, ROTING_KEY, customerStaffChangedEvent);
        }
        return true;
    }

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {

        int pageSize = 5;


        // 获取外部系统信息
        val outsourcingSystem = outsourcingSystemService.findOutsourcingSystemById(systemId);


        // 获取外部系统需要同步数据的数量
        val dto = OutsourcingSystemConverter.INSTANCE.convertToDto(outsourcingSystem);
        val counts  = customerIntegrationServiceApi.getCustomerStaffCount(dto).getData();

        log.info("will sync {} customer staffs from {}", counts, outsourcingSystem.getSystemName());

        int pages = 0;
        if (counts % pageSize != 0) {
            pages = Math.toIntExact(counts / pageSize) + 1;
        } else {
            pages = Math.toIntExact(counts / pageSize);
        }



        for (int i = 0; i < pages ; i++) {
            // 通过外部系统信息，获取外部客户系统的客户信息
            val customerStaffs = customerIntegrationServiceApi.fetchCustomerStaffs(i, pageSize, dto).getData();
//            List<CustomerStaff> customerStaffs = customerIntegrationServiceApi.fetchCustomerStaffs(i, pageSize , dto);

            log.info("sync {} customer staffs from {}", customerStaffs.size(), outsourcingSystem.getSystemName());

            customerStaffs.forEach(staff -> {
                val dbStaff = customerStaffMapper.findCustomerStaff(staff.getAccountId(), staff.getSystemId());
                val customerStaff = CustomerIntegrationConverter.INSTANCE.convertToCustomerStaff(staff);
                if (dbStaff != null) {
                    log.debug("find {} staff from db", dbStaff);
                    // 在数据库中，比较 update time
                    if ( dbStaff.getUpdateTime() != null && staff.getUpdateTime() != dbStaff.getUpdateTime()) {
                        // update time 不相等，说明数据发生了更新
                        customerStaffMapper.updateCustomerStaff(customerStaff);
                    }
                } else {
                    // 不在数据库中，直接插入
                    customerStaffMapper.createCustomerStaff(customerStaff);
                }

            });

        }

    }
}
