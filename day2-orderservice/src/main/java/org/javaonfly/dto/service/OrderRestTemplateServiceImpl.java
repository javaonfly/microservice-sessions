package org.javaonfly.dto.service;

import java.util.ArrayList;
import java.util.List;

import org.javaonfly.dto.OrderDTO;
import org.javaonfly.dto.OrderStatus;
import org.javaonfly.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component("restTemplateClient")
@Slf4j
public class OrderRestTemplateServiceImpl implements IOrderService {

	@Autowired
	RestTemplate restTemplate;

	public List<OrderDTO> getAllOrders() {

		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		OrderDTO firstOrder = OrderDTO.builder().id(1l).orderStatus(OrderStatus.CREATED).userName("John").build();

		List<ProductDTO> productList = new ArrayList<>();

		productList = restTemplate.getForEntity("http://product-service/api/v1/products/", List.class).getBody();
		firstOrder.setProducts(productList);
		log.info("Using Rest Template");
		orderList.add(firstOrder);
		return orderList;

	}

}
