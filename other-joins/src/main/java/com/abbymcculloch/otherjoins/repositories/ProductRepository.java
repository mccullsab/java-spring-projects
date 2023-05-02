package com.abbymcculloch.otherjoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abbymcculloch.otherjoins.models.Category;
import com.abbymcculloch.otherjoins.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Product findByIdIs(Long id);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}