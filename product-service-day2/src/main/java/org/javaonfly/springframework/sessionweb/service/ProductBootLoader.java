package org.javaonfly.springframework.sessionweb.service;

import org.javaonfly.springframework.sessionweb.dao.ProductRepository;
import org.javaonfly.springframework.sessionweb.dao.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class ProductBootLoader implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(Product.builder().name("Pen").price(0.5d).description("NewPen").build());
		productRepository.save(Product.builder().name("Pencil").price(0.4d).description("NewPencil").build());
		log.info("Number of records in the database -- " + productRepository.count());

	}

}
