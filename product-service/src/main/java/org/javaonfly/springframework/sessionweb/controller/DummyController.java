package org.javaonfly.springframework.sessionweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {
	
	@Autowired
	Environment environment;

	@GetMapping()
	public String dummayPage() {
		return "Welcome to Dummy page from "+environment.getProperty("local.server.port");
	}
	
}
