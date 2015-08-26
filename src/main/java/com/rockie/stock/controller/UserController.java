package com.rockie.stock.controller;

import com.rockie.stock.model.User;
import com.rockie.stock.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by froilan on 8/18/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.POST)
	public User add(@RequestBody User user) {
		System.out.println("***ADD");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userDao.saveAndFlush(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable long id) {
		System.out.println("****FIND");
		return userDao.findOne(id);
	}
}
