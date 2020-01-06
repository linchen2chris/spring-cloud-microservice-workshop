package com.clin.sample.controller;

import com.clin.sample.entity.User;
import com.clin.sample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User findById(@PathVariable("id") long id) {
		System.out.println("------->${id}" + id);

		User user = this.userRepository.findOne(id);
		System.out.println("------->${id}" + user.toString());
		return user;
	}
}
