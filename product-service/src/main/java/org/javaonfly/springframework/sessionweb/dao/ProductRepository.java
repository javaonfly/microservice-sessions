package org.javaonfly.springframework.sessionweb.dao;

import org.javaonfly.springframework.sessionweb.dao.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{

	
}
