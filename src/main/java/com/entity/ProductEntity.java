package com.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {

	String productName;
	Integer price;
	Integer qty;
	Float tax;
	//private 
	//getters and setters 
	//lombok -> private , getters and setters 
}

