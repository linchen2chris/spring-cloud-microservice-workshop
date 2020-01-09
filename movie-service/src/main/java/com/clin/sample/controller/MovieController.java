package com.clin.sample.controller;

import com.clin.sample.UserServiceFeignClient;
import com.clin.sample.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Value("${profiles}")
	private String profile;

	@Autowired
	private UserServiceFeignClient client;

	@Autowired
	private LoadBalancerClient loadbalanceClient;

	@GetMapping("/profiles")
	public String getProfile() {
		return this.profile;
	}

	@HystrixCommand(fallbackMethod = "findByIdFallback")
	@GetMapping("/user/{id}")
	public User findById(@PathVariable("id") Long id) {
		return this.client.getUser(id);
	}
	@PostMapping("/user/create")
	public User createUser(@RequestBody() User user) {
		return this.client.createUser(user);
	}

	@GetMapping("/log-instance")
	public void logUserIntance() {
		ServiceInstance serviceInstance = this.loadbalanceClient.choose("user-service");
		MovieController.LOGGER.info("chen{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}

	public User findByIdFallback(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setName(null);
		user.setAge(null);
		user.setName("defaultUser");
		return user;
	}

}
