package org.javaonfly.springframework.sessionweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class,ManagementWebSecurityAutoConfiguration.class })
public class SessionWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionWebApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
     return new OpenAPI()
          .info(new Info()
          .title("Product application API")
          .termsOfService("http://swagger.io/terms/")
          .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
