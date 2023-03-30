create table `cs_apm_record` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`service_name` varchar(20) COMMENT '服务名',
`path` varchar(20) COMMENT '请求路径',
`type` varchar(20) COMMENT '请求类型',
`query_params` varchar(255) COMMENT '请求参数',
`take_time` bigint(20) COMMENT '请求花费时间',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`)
);
