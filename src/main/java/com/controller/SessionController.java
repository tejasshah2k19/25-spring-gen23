package com.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.MailerService;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	Cloudinary cloudinary;

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
	public String saveUser(UserEntity userEntity, @RequestParam MultipartFile profilePic) {
		// read
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		// validation
		if (profilePic == null || profilePic.getSize() == 0 || !profilePic.getOriginalFilename().endsWith(".jpg")) {

		}

		System.out.println(profilePic.getOriginalFilename());
		System.out.println(profilePic.getSize());// bytes
		if (profilePic.getSize() >= 10 * 1024) {

		}

		try {

			Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());

			System.out.println(result);
			String imagePath = result.get("secure_url").toString();
			System.out.println(imagePath);

			userEntity.setProfilePicPath(imagePath);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// db save
		userDao.addUser(userEntity);

//		mailerService.sendWelcomeMail(userEntity.getEmail(),userEntity.getFirstName());
		return "Login"; // jsp->Login
	}

}
