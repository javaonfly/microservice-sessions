package org.javaonfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Day2ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day2ConfigserverApplication.class, args);
	}

}
