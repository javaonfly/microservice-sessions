package org.javaonfly.dto.controller;

import java.util.List;

import org.javaonfly.dto.OrderDTO;
import org.javaonfly.dto.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/orders")
@RestController
public class OrderController {

	@Autowired

	@Qualifier("feignClientService")
	IOrderService feignClientService;

	@Autowired
	@Qualifier("restTemplateClient")
	IOrderService restTemplateClient;

	@GetMapping()
	public ResponseEntity<List<OrderDTO>> getOrders(@RequestParam("type") String type) {
		List<OrderDTO> orderList = null;
		if (type.equalsIgnoreCase("feign")) {
			orderList = feignClientService.getAllOrders();
		} else {
			orderList = restTemplateClient.getAllOrders();
		}
		return new ResponseEntity<List<OrderDTO>>(orderList, HttpStatus.OK);
	}

}
