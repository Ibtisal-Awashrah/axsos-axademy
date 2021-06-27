package com.axsos.prooducts_categories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.prooducts_categories.models.Category;
import com.axsos.prooducts_categories.models.CategoryProduct;
import com.axsos.prooducts_categories.models.Product;
import com.axsos.prooducts_categories.repositories.CategoryProductRepository;
import com.axsos.prooducts_categories.repositories.CategoryRepositroy;
import com.axsos.prooducts_categories.repositories.ProductRepository;

@Service
public class AppService {
	private final CategoryRepositroy categRepo;
	private final ProductRepository prodRepo;
	private final CategoryProductRepository catProRepo;
	public AppService(CategoryRepositroy categRepo, ProductRepository prodRepo, CategoryProductRepository catProRepo) {
		this.categRepo = categRepo;
		this.prodRepo = prodRepo;
		this.catProRepo = catProRepo;
	}
	
	public Product findProductById (Long id) {
		return prodRepo.findById(id).orElse(null);
	}
	
	public Category findCategoryById (Long id) {
		return categRepo.findById(id).orElse(null);
		
	}
	public List<Product> unAddedProducts (Category c){
		return prodRepo.findByCategoriesNotContains(c);
	}
	
	public List <Category> unAddedCategory (Product p){
		return categRepo.findByProductsNotContains(p);
	}
	
	public Product addProduct (Product p) {
		return prodRepo.save(p);
	}
	
	public Category addCategory (Category c) {
		return categRepo.save(c);
	}
	
	public CategoryProduct add ( CategoryProduct cP) {
		return catProRepo.save(cP);
	}

}
