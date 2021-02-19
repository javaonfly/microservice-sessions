package org.javaonfly.springframework.sessionweb.controller;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.javaonfly.springframework.sessionweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDataController {

	@Autowired
	@Qualifier("productRestTemplate")
	IProductService productService;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("productFeignClientService") IProductService productService;
	 */

	@GetMapping()
	public String getProducts(Model model, @AuthenticationPrincipal OidcUser principal) {

		List<ProductDTO> prodList = productService.getProducts(principal);
		model.addAttribute("products", prodList);
		return "products";
	}

}
