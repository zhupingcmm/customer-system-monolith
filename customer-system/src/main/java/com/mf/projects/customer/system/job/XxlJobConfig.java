package com.mf.projects.customer.system.job;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class XxlJobConfig {

    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${xxl.job.executor.appname}")
    private String appname;

    @Value("${xxl.job.executor.logpath}")
    private String logpath;

    @Value("${xxl.job.executor.logretentiondays}")
    private int logretentiondays;

    @Bean
    public XxlJobSpringExecutor xxlJobSpringExecutor () {
        log.info("init xxl job");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setLogPath(logpath);
        xxlJobSpringExecutor.setLogRetentionDays(logretentiondays);
        return xxlJobSpringExecutor;
    }
}
