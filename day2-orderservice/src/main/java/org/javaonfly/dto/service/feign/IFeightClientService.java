package org.javaonfly.dto.service.feign;

import java.util.ArrayList;
import java.util.List;

import org.javaonfly.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "product-service")
public interface IFeightClientService {

	@CircuitBreaker(name = "product-feigh-error", fallbackMethod = "getDefaultProducts")
	@GetMapping("/api/v1/products/")
	public List<ProductDTO> getNewProducts();

	default public List<ProductDTO> getDefaultProducts(java.lang.Throwable t) {
		List<ProductDTO> defaultPRoductList = new ArrayList<>();
		defaultPRoductList.add(ProductDTO.builder().id(9999)
				.description("returning dummy data as error occured as " + t.getMessage()).build());
		return defaultPRoductList;
	}
}
