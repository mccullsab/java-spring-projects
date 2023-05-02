package com.abbymcculloch.otherjoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abbymcculloch.otherjoins.models.Category;
import com.abbymcculloch.otherjoins.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	Category findByIdIs(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}