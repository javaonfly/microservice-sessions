package org.javaonfly.springframework.sessionweb;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.javaonfly.springframework.sessionweb.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	IProductService productService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testGetProducts() throws Exception {
		mockMvc.perform(get("/api/v1/product/").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(200));
	}

	@Test
	void testPostProducts() throws Exception {
		ProductDTO product = ProductDTO.builder().name("TestProduct").description("This is test product").build();
		String input = objectMapper.writeValueAsString(product);
		System.out.println("Pass ing " + input);
		when(productService.createProduct(product)).thenReturn(product);
		mockMvc.perform(post("/api/v1/product/").contentType(MediaType.APPLICATION_JSON).content(input))
				.andExpect(status().is(201));
	}

}
