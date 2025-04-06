package com.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookEntity {
	
	@NotBlank(message = "Please Enter Book Name")
	@Pattern(regexp = "[a-zA-Z\\s]+",message = "Please Enter Valid Book Name")
	String bookName;
	
	
	@Pattern(regexp = "[a-zA-Z\\s]+",message="Please Enter Valid Category")
	@NotBlank(message = "Please Enter Category")
	String category;
	
	@Min(value = 1,message = "Price must be > 1")
	@Max(value = 500000,message = "Price must be < 500000")
	@NotNull(message = "Please Enter Price")
	Integer price;
	
	
	@NotNull(message = "Please Enter Tax")
	Float tax; 
	
}
