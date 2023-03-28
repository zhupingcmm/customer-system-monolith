package com.mf.cs.gateway.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mf.cs.gateway.entity.ApmRecord;
import lombok.val;

import java.util.List;

public interface ApmMapper extends BaseMapper<ApmRecord> {

    default List<ApmRecord> getApmRecords(long pageSize, long currentPage) {
        Page<ApmRecord> page = new Page<>(currentPage, pageSize);
        val ipage = selectPage(page, null);

        return ipage.getRecords();
    }


}
