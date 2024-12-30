package com.springbootmvcemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.springbootmvcemp.entity.EmployeeEntity;
import com.springbootmvcemp.model.Employee;
import com.springbootmvcemp.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller

public class EmployeeController {

@Autowired
EmployeeService employeeService;

@GetMapping("/employeeDetails")
public String getEmployeeForm() {
    return "add_employee";
}

@PostMapping("/saveDetails")
public String saveDetails(Employee employee) {
  
    System.out.println(employee);
    return "Emp_success";
}

@GetMapping("/getalldetails")
public String getAllDetails(Model model) {
	
	List<EmployeeEntity> employ=employeeService.getAllDetails();
	model.addAttribute("employ", employ);
	
    return "Emp_list";
}

@GetMapping("/search_form")
public String getSearchform()
{
	return "searchform";
}

@PostMapping("/searchbyid")
public String searchById(@RequestParam long id,Model model) {    
	EmployeeEntity employ=employeeService.searchById(id);
	model.addAttribute("employ",employ);
    return "search_form";
}

@GetMapping("/delete/{id}")
public String deleteById(@PathVariable("id") long id) {
	employeeService.deleteByIdEmployee(id);
    return "redirect:/getalldetails";
}

@GetMapping("/edit/{id}")
public String editById(@PathVariable long id , Model model) {
	Employee employ =employeeService.editById(id);
	model.addAttribute("employ",employ);
	model.addAttribute("id",id);
    return "editform";
    
}

@PostMapping("/editdetails/{id}")
public String updateDetails(@PathVariable long id, @ModelAttribute Employee employee) {
    employeeService.updateById(id, employee);
    return "redirect:/getalldetails";
}



}
