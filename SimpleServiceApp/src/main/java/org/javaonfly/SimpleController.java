package org.javaonfly;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SimpleController {
	
	@GetMapping
	public String getSimpleMsg() {
		return "Hello from Simple Controller";
	}

}
