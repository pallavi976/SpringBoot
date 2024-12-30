package com.springbootmvcemp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private String name;
	private double salary;
	private String dept;
	private String address;
	private int pfPercentage=9;
	
	
}
