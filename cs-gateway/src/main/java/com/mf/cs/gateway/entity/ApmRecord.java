package com.mf.cs.gateway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mf.projects.cs.infrastructure.base.BaseBean;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;

import java.time.LocalDateTime;

@Data
@TableName("cs_apm_record")
@Builder
public class ApmRecord extends BaseBean {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 请求服务名称
     */
    private String serviceName;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 请求类型
     */
    private HttpMethod type;


    /**
     * 请求参数
     */
    private String queryParams;

    /**
     * 请求花费时间
     */

    private Long takeTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
