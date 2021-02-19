package org.javaonfly.springframework.sessionweb.service.client;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import feign.Headers;

@FeignClient(name = "productClient", url = "http://localhost:8080")
public interface IFeignClient {
	String AUTH_TOKEN = "Authorization";

	@GetMapping("/api/v1/products/")
	@Headers("Content-Type: application/json")
	List<ProductDTO> findUsers();
}