package com.springbootmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int quantity;
	private int discountRate;
	private int taxRate;
	private double discountPrice;
	private double offerPrice;
	private double finalPrice;
	private double stockValue;
	
	
	
	
	
}
