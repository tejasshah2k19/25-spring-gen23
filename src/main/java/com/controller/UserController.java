package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dao.UserDao;
import com.entity.UserEntity;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/listuser")
	public String listUser(Model model) {
		List<UserEntity> users = userDao.getAllUsers();
		model.addAttribute("users",users);
		return "ListUser";
	}

	@GetMapping("search")
	public String searchUser() {
		return "SearchUser";
	}
	
	@PostMapping("searchuser")
	public String searchUserDb(String firstName,Model model) {
		List<UserEntity> users = userDao.searchByFirstName(firstName);
		model.addAttribute("users",users);
		
		return "ListUser";
	}
	
}
