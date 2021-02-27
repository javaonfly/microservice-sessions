package org.javaonfly.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

	private long id;
	private OrderStatus orderStatus;
	private String userName;

	private List<ProductDTO> products;

	

}
