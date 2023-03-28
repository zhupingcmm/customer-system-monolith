package com.mf.cs.gateway.service;


import com.mf.cs.gateway.entity.ApmRecord;

import java.util.List;

public interface ApmService {

    void addRecord(ApmRecord record);

    List<ApmRecord> getRecords(long pageSize, long currentPage);

}
