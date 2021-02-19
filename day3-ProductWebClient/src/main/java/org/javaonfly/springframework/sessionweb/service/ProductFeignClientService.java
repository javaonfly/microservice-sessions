package org.javaonfly.springframework.sessionweb.service;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.javaonfly.springframework.sessionweb.service.client.IFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service("productFeignClientService")
public class ProductFeignClientService implements IProductService {

	@Autowired
	OAuth2AuthorizedClientService oauth2ClientService;

	@Autowired
	IFeignClient client;

	@Override
	public List<ProductDTO> getProducts(OidcUser principal) {
		
		List<ProductDTO> prodList = client.findUsers();
		return prodList;
	}

}
