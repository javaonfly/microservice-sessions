package org.javaonfly;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class GatewayConfiguration {

	@Bean
	public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/v1/products*", "/api/v1/products/*")
						.filters(f -> f.addResponseHeader("Hello", "World")).uri("lb://product-service"))
				
				.route(p -> p.path("/dummy")
						.filters(f -> f.circuitBreaker(
								config -> config.setName("product-cb").setFallbackUri("forward:/fallback")))
						.uri("lb://product-service"))
				.build();
	}

	@RequestMapping("/fallback")
	public String fallback() {
		return "fallback";
	}

}
