package com.rockie.stock;

import com.rockie.stock.model.User;
import com.rockie.stock.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user = new User();
		user.setEmail("len@gmail.com");
		user.setPassword(new BCryptPasswordEncoder().encode("password"));
		userDao.saveAndFlush(user);
	}

}
