package com.limit.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limit.limitservice.model.LimitConfiguration;

@RestController
public class LimitServiceController {

	
	@Autowired 
	Configuration config;
	
	@GetMapping("/name")
		public String getName() {
			return "Vikas";
		}
	
	@GetMapping("/limit")
	public LimitConfiguration getLimitConfig() {
		return new LimitConfiguration(config.getMax(),config.getMin());
	}
}
