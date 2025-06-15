package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.MailerService;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	MailerService mailerService;

	@GetMapping({ "/", "register" })
	public String signup() {
		return "Register";// Jsp Name
	}

	@GetMapping("login")
	public String signIN() {
		return "Login";// jsp name
	}

	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity) {
		// read
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		// validation
		// db save
		userDao.addUser(userEntity);

		mailerService.sendWelcomeMail(userEntity.getEmail(),userEntity.getFirstName());
		return "Login"; // jsp->Login
	}

}
