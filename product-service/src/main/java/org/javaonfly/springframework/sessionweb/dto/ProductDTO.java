package org.javaonfly.springframework.sessionweb.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.EntityModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO extends EntityModel<ProductDTO> {

	private long id;
	@Size(min = 4, message = "Name should be greater than 4 charecters")
	private String name;

	@NotNull(message = "Description should not be empty")
	private String description;
	private double price;

	private String discount;

}
