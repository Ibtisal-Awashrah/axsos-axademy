package com.axsos.prooducts_categories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.prooducts_categories.models.Category;
import com.axsos.prooducts_categories.models.CategoryProduct;
import com.axsos.prooducts_categories.models.Product;
import com.axsos.prooducts_categories.services.AppService;

@Controller
public class AppController {
	
	private final AppService appService ;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	
	@GetMapping("/products/new")
	public String newProduct (@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(@Valid@ModelAttribute("product")Product product, BindingResult result) {
		if (result.hasErrors())
			return "newProduct.jsp";
		
		appService.addProduct(product);
		return "redirect:/product/"+product.getId();
	}
	
	@GetMapping("/product/{id}")
	public String showProduct (@PathVariable("id") Long id, @ModelAttribute("relation")CategoryProduct relation, Model model) {
		
		model.addAttribute("product", appService.findProductById(id));
		model.addAttribute("categories", appService.unAddedCategory(appService.findProductById(id)));
		System.out.println("hi");
		return "showProduct.jsp";
		
	}
	
	@PostMapping("/product/addCategory")
	public String addCategoryToProduct(@ModelAttribute("relation") CategoryProduct releation) {
		appService.add(releation);
		return "redirect:/product/"+releation.getProduct().getId();
		
	}
	
	@GetMapping("/categories/new")
	public String newCategory (@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/category/create")
	public String createProduct(@Valid@ModelAttribute("category")Category category, BindingResult result) {
		if (result.hasErrors())
			return "newCategory.jsp";
		
		appService.addCategory(category);
		return "redirect:/category/"+category.getId();
	}
	
	@GetMapping("/category/{id}")
	public String showCategory (@PathVariable("id") Long id, @ModelAttribute("relation")CategoryProduct relation, Model model) {
		
		model.addAttribute("category", appService.findCategoryById(id));
		model.addAttribute("products", appService.unAddedProducts(appService.findCategoryById(id)));
		return "showCategory.jsp";
	}
	
	@PostMapping("/category/addProduct")
	public String addProductToCategory(@ModelAttribute("relation") CategoryProduct releation) {
		appService.add(releation);
		return "redirect:/category/"+releation.getCategory().getId();
		
	}
	

}
