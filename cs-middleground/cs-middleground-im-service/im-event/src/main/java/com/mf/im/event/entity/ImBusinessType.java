package com.mf.im.event.entity;

import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Data;

@Data
public class ImBusinessType extends BaseBean {

    private Long id;

    private String businessTypeCode;

    private String businessTypeName;
}
