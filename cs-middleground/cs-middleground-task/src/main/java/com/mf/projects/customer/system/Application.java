package com.mf.projects.customer.system;

import com.mf.projects.customer.system.loadbalancer.TagLoadBalancerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

import static com.mf.projects.customer.system.feign.ApiConstants.SERVICE_NAME;

@LoadBalancerClients({
		@LoadBalancerClient(value = SERVICE_NAME, configuration = TagLoadBalancerClient.class)
})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
