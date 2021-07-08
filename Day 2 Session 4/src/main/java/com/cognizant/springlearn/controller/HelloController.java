package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloController {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping(value="")
	public String sayHello() {
		LOGGER.info("Start of Hello World");
		LOGGER.info("End of Hello World");
		return "Hello World!";
	}

}
