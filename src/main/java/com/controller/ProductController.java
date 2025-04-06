package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.ProductEntity;

@Controller
public class ProductController {

	@GetMapping("newproduct")
	public String newProduct() {
		return "NewProduct";//jsp name 
	}
	
	
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity product,Model model) {
		//name price qty 
		//read print 
		//bean / entity 
		System.out.println(product.getProductName());
		model.addAttribute("product",product);
		return "PrintProduct";
	}
}
