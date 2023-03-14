package com.mf.projects.customer.system.config;

import com.mf.projects.customer.system.loadbalancer.TagLoadBalancerClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfig {

    @Bean
    public ReactorServiceInstanceLoadBalancer customLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSuppliers) {

        return  new TagLoadBalancerClient(serviceInstanceListSuppliers);

    }
}
