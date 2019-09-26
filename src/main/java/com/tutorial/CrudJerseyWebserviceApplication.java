package com.tutorial;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.entity.ProductEntity;
import com.tutorial.service.ProductService;

@SpringBootApplication
public class CrudJerseyWebserviceApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(CrudJerseyWebserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ProductEntity p1 = new ProductEntity("Evian", "Eau minerale", 2.05);
		ProductEntity p2 = new ProductEntity("Marseillaise", "Savon", 1.05);
		ProductEntity p3 = new ProductEntity("Kiri", "Produit laitière", 3.05);

		productService.addMultipleProducts(Arrays.asList(p1,p2,p3));

	}

}
