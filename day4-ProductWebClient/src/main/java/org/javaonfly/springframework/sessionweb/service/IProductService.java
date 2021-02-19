package org.javaonfly.springframework.sessionweb.service;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public interface IProductService {

	public List<ProductDTO> getProducts(OidcUser principal);
}
