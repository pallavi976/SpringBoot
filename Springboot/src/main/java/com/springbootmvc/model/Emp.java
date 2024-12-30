package com.springbootmvc.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Emp {
	int empId;
	String empName;
	double empSalary;

	public static void main(String[] args) {
		
		Emp emp =Emp.builder()
				.empId(101)
				.empName("Ratan")
				.empSalary(12000.45)
				.build();
		System.out.println(emp);

	}

}
