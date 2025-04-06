package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.BookEntity;

@Controller
public class BookController {

	@GetMapping("newbook")
	public String newBook() {
		return "NewBook";
	}

	@PostMapping("savebook")
	public String saveBook(@Validated BookEntity bookEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("result",result);
			model.addAttribute("book", bookEntity);
			
			return "NewBook";
		} else {
			model.addAttribute("book", bookEntity);
			return "PrintBook";
		}
	}
}












