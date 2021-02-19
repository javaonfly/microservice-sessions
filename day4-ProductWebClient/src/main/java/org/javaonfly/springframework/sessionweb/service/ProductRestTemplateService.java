package org.javaonfly.springframework.sessionweb.service;

import java.util.List;

import org.javaonfly.springframework.sessionweb.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("productRestTemplate")
public class ProductRestTemplateService implements IProductService {

	@Autowired
	OAuth2AuthorizedClientService oauth2ClientService;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<ProductDTO> getProducts(OidcUser principal) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

		OAuth2AuthorizedClient oauth2Client = oauth2ClientService
				.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());

		String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
		System.out.println("jwtAccessToken = " + jwtAccessToken);

		System.out.println("Principal = " + principal.getSubject());

		String url = "http://localhost:8080/api/v1/products/";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + jwtAccessToken);

		HttpEntity<List<ProductDTO>> entity = new HttpEntity<>(headers);

		ResponseEntity<List<ProductDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<ProductDTO>>() {
				});
		List<ProductDTO> prodList = responseEntity.getBody();
		return prodList;
	}

}
