package org.javaonfly.springframework.sessionweb.service;

import java.util.ArrayList;
import java.util.List;

import org.javaonfly.springframework.sessionweb.dao.ProductRepository;
import org.javaonfly.springframework.sessionweb.dao.model.Product;
import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.javaonfly.springframework.sessionweb.service.exception.ProductNotFoundException;
import org.javaonfly.springframework.sessionweb.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;

	@Override
	public List<ProductDTO> getProducts() {
		log.info("Getting all data");
		List<ProductDTO> products = new ArrayList<>();
		productRepository.findAll().forEach(prod -> products.add(productMapper.getDTOFromDAO(prod)));
		return products;
	}

	@Override
	public ProductDTO getProduct(long id) throws ProductNotFoundException {
		return productMapper.getDTOFromDAO(productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("No details found for id = " + id)));
	}

	@Override
	public ProductDTO createProduct(ProductDTO product) {
		Product productDB = productMapper.getDAOFromDTO(product);
		return productMapper.getDTOFromDAO(productRepository.save(productDB));
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		Product productDB = productMapper.getDAOFromDTO(product);
		return productMapper.getDTOFromDAO(productRepository.save(productDB));
	}

}
