package org.javaonfly.dto.service;

import java.util.ArrayList;
import java.util.List;

import org.javaonfly.dto.OrderDTO;
import org.javaonfly.dto.OrderStatus;
import org.javaonfly.dto.ProductDTO;
import org.javaonfly.dto.service.feign.IFeightClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("feignClientService")
@Slf4j
public class OrderFeignClientServiceImpl implements IOrderService {

	@Autowired
	IFeightClientService feignClientService;

	public List<OrderDTO> getAllOrders() {

		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		OrderDTO firstOrder = OrderDTO.builder().id(1l).orderStatus(OrderStatus.CREATED).userName("John").build();

		List<ProductDTO> productList = new ArrayList<>();

		productList = feignClientService.getNewProducts();
		firstOrder.setProducts(productList);
		log.info("Using Feign Client");
		orderList.add(firstOrder);
		return orderList;

	}

}
