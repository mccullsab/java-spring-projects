package com.abbymcculloch.otherjoins.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abbymcculloch.otherjoins.models.Category;
import com.abbymcculloch.otherjoins.models.Product;
import com.abbymcculloch.otherjoins.repositories.ProductRepository;


@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getAssignedProducts(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedProducts(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}