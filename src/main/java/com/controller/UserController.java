package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dao.UserDao;
import com.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/listuser")
	public String listUser(Model model) {
		List<UserEntity> users = userDao.getAllUsers();
		model.addAttribute("users", users);
		return "ListUser";
	}

	@GetMapping("search")
	public String searchUser() {
		return "SearchUser";// open jsp
	}

	@PostMapping("searchuser")
	public String searchUserDb(String firstName, Model model) {
		List<UserEntity> users = userDao.searchByFirstName(firstName);
		model.addAttribute("users", users);

		return "ListUser";// open jsp
	}

	@GetMapping("deleteuser")
	public String deleteUser(Integer userId) {
		System.out.println(userId);
		userDao.deleteUser(userId);
		return "redirect:/listuser";// will call url
	}

	@GetMapping("viewuser")
	public String viewUser(Integer userId,Model model) {
		System.out.println(userId);
		UserEntity user = userDao.getByUserId(userId);
		model.addAttribute("user",user);
		return "ViewUser";
	}
	
	@GetMapping("edituser")
	public String editUser(Integer userId,Model model) {
		System.out.println(userId);
		UserEntity user = userDao.getByUserId(userId);
		model.addAttribute("user",user);
		return "EditUser";
	}

	@PostMapping("updateuser")
	public String updateUser(UserEntity user) {
		//firstName 
		//userId 
		
		userDao.updateUser(user);
		return "redirect:/listuser";
	}
	
	
}








