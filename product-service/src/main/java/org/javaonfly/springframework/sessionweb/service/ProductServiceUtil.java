package org.javaonfly.springframework.sessionweb.service;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;

public final class ProductServiceUtil {
	private ProductServiceUtil() {
		// added
	}

	public static ProductDTO generateProduct(long id) {
		return ProductDTO.builder().id(id).name("Product" + id).price(123d).description("This is product " + id).build();
	}
}
