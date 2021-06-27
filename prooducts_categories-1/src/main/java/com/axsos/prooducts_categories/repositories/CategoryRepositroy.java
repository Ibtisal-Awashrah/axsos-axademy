package com.axsos.prooducts_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.prooducts_categories.models.Category;
import com.axsos.prooducts_categories.models.Product;

@Repository
public interface CategoryRepositroy extends CrudRepository<Category, Long>{
	List <Category> findAll();
	List <Category> findByProductsNotContains(Product product);
}
