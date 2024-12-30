package com.springbootmvc.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	@NotBlank(message = "Product name can not be blank")
	private String name;
	@NotBlank(message = "Product brand can not be blank")
	private String brand;
	@NotBlank(message = "Made In field can not be blank")
	private String madeIn;
	@Positive(message = "Price must be greater than zero")
	private double price;
	@Min(value = 1 , message = "Quantity must be atleast one")
	private int quantity;
	@DecimalMax(value="100.0" , message = "Discount cannot exceed 100")
	private int discountRate;
	private int taxRate;
	
	
}
