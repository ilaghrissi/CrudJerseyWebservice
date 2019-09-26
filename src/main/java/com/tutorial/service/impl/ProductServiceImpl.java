package com.tutorial.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.entity.ProductEntity;
import com.tutorial.repository.ProductRepository;
import com.tutorial.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(ProductEntity p) {
		productRepository.save(p);

	}

	@Override
	public void addMultipleProducts(Iterable<ProductEntity> p) {
		productRepository.saveAll(p);

	}

	@Override
	public ProductEntity updateProduct(ProductEntity p, Long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		ProductEntity result = null;
		if (product.isPresent()) {
			result = productRepository.save(p);
		}

		return result;
	}

	@Override
	public boolean deleteProduct(Long id) {
		Optional<ProductEntity> p = productRepository.findById(id);
		if (p.isPresent()) {
			productRepository.delete(p.get());
			return true;
		}

		return false;

	}

	@Override
	public ProductEntity findProductById(Long id) {
		ProductEntity p = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

		return p;
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		Iterable<ProductEntity> iterable = productRepository.findAll();
		List<ProductEntity> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
		
		return result;
	}

}
