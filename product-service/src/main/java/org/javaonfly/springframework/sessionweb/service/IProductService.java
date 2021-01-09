package org.javaonfly.springframework.sessionweb.service;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.javaonfly.springframework.sessionweb.service.exception.ProductNotFoundException;

public interface IProductService {

	List<ProductDTO> getProducts();

	ProductDTO getProduct(long id) throws ProductNotFoundException;

	ProductDTO createProduct(ProductDTO product);

	ProductDTO updateProduct(ProductDTO product);

}
