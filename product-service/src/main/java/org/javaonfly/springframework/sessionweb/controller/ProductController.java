package org.javaonfly.springframework.sessionweb.controller;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.javaonfly.springframework.sessionweb.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	IProductService productService;

	Logger LOGGER = LoggerFactory.getLogger("ProductController");

	@Operation(description = "Returns all the products")
	@GetMapping()
	public ResponseEntity<List<ProductDTO>> getProducts() {
		List<ProductDTO> productList = productService.getProducts();
		return new ResponseEntity<List<ProductDTO>>(productList, HttpStatus.OK);
	}

	@Operation(description = "Returns the product based on the given id")
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable("productId") Long productId) {

		ProductDTO product = productService.getProduct(productId);
		/*
		 * WebMvcLinkBuilder linkToAll =
		 * linkTo(methodOn(this.getClass()).getProducts());
		 * product.add(linkToAll.withRel("all-products"));
		 * 
		 * WebMvcLinkBuilder linkToSelf =
		 * linkTo(methodOn(this.getClass()).getProduct(productId));
		 * product.add(linkToSelf.withRel("self-link"));
		 */
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity addProduct(@Validated @RequestBody ProductDTO product) {
		ProductDTO productResult = productService.createProduct(product);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/v1/product/" + productResult.getId());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping("/{productId}")
	public ResponseEntity updateProduct(@RequestBody ProductDTO product) {
		LOGGER.info("Product received " + product);
		ProductDTO productResult = productService.createProduct(product);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/v1/product/" + productResult.getId());
		return new ResponseEntity(headers, HttpStatus.OK);
	}

}
