package com.tutorial.service;

import java.util.List;

import com.tutorial.entity.ProductEntity;

public interface ProductService {

	/**
	 * Add new product
	 * 
	 * @param p
	 */
	public void addProduct(ProductEntity p);
	
	/**
	 * Add multiple products
	 * 
	 * @param p
	 */
	public void addMultipleProducts(Iterable<ProductEntity> p);

	/**
	 * Update existing product by id
	 * 
	 * @param p
	 * @param id
	 * @return
	 */
	public ProductEntity updateProduct(ProductEntity p, Long id);

	/**
	 * Delete product by id
	 * 
	 * @param id
	 */
	public boolean deleteProduct(Long id);

	/**
	 * Get product by id
	 * 
	 * @param id
	 * @return
	 */
	public ProductEntity findProductById(Long id);
	
	/**
	 * Get all products
	 * @return
	 */
	public List<ProductEntity> findAllProducts();
}
