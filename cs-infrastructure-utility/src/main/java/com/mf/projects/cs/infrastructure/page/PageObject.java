package com.mf.projects.cs.infrastructure.page;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@ToString
@Accessors(chain = true)
public class PageObject<T> {

    private Long total;

    private Long pageIndex;

    private Long pageSize;

    private List<T> list;


}
