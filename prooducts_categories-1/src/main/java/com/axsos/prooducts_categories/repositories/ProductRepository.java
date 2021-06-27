package com.axsos.prooducts_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.prooducts_categories.models.Category;
import com.axsos.prooducts_categories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List <Product> findAll();
	List <Product> findByCategoriesNotContains(Category category);

}
