package com.bugfree.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

	@Autowired
	UserDao userRepository;

	@RequestMapping(value = "/api/user/current", method = RequestMethod.GET)
	public User getCurrent() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof UserAuthentication) {
			return ((UserAuthentication) authentication).getDetails();
		}
		return new User(); //anonymous user support
	}

	@RequestMapping(value = "/admin/api/user", method = RequestMethod.GET)
	public List<User> list() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/users", method = POST)
	public User createUser(@RequestBody User user){
		userRepository.save(user);
		return user;
	}

}
