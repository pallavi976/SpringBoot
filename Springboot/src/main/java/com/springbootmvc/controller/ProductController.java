package com.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.springbootmvc.entity.ProductEntity;
import com.springbootmvc.model.ProductModel;
import com.springbootmvc.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProductController {

@Autowired
ProductService productService;
	
@GetMapping("/productForm")
public String getProductForm() 
{
    return "product_details";
}



@PostMapping("/saveProduct")

public String saveProduct(@Valid ProductModel productModel)
{
	productService.saveProductDetails(productModel);
	return "success";
}


@GetMapping("/getallproducts")
public String getAllProducts(Model model) {
	
	List<ProductEntity> products=productService.getAllProducts();
	model.addAttribute("products", products);
	
    return "product-list";
}

@GetMapping("/searchform")
public String getSearchform()
{
	return "search_form";
}

@PostMapping("/searchbyid")
public String searchById(@RequestParam long id,Model model) {    
	ProductEntity product=productService.searchById(id);
	model.addAttribute("product",product);
    return "search_form";
}

@GetMapping("/delete/{id}")
public String deleteById(@PathVariable("id") long id) {
	productService.deleteByIdProduct(id);
    return "redirect:/getallproducts";
}

@GetMapping("/edit/{id}")
public String editById(@PathVariable long id , Model model) {
	ProductModel product =productService.editById(id);
	model.addAttribute("product",product);
	model.addAttribute("id",id);
    return "edit-product";
    
}

@PostMapping("/editproductsave/{id}")
public String updateProduct(@PathVariable long id , @ModelAttribute ProductModel productModel) {
    //TODO: process POST request
	productService.updateById(id , productModel);
	
    return "redirect:/getallproducts";
}

}

