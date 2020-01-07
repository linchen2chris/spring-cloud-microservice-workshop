package com.clin.sample.controller;

import com.clin.sample.UserServiceFeignClient;
import com.clin.sample.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private UserServiceFeignClient client;

	@Autowired
	private LoadBalancerClient loadbalanceClient;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable("id") Long id) {
		return this.client.getUser(id);
	}

	@GetMapping("/log-instance")
	public void logUserIntance() {
		ServiceInstance serviceInstance = this.loadbalanceClient.choose("user-service");
		MovieController.LOGGER.info("chen{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}
}
