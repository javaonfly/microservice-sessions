package org.javaonfly.springframework.sessionweb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties("product-service")
@Data
public class ProductProperties {

	private String discount;

}
