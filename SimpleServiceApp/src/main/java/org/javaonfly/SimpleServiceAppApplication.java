package org.javaonfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleServiceAppApplication {

	public static void main(String[] args) {
		//System.out.println("----args added--------");
		for(String s:args) {
			System.out.println(s);
		}
		SpringApplication.run(SimpleServiceAppApplication.class, args);
	}

}
