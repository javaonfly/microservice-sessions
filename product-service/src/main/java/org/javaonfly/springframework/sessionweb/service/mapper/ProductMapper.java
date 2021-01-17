package org.javaonfly.springframework.sessionweb.service.mapper;

import org.javaonfly.springframework.sessionweb.dao.model.Product;
import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

	ProductDTO getDTOFromDAO(Product product);

	Product getDAOFromDTO(ProductDTO productDTO);

}
