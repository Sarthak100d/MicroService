package com.limit.limitservice.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class Configuration {
	
	private int min;
	private int max;
	public  Configuration() {
		
	}
	public Configuration(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	public int getMin() {
		return min;
	}

	
	  public void setMin(int min) { this.min = min; }
	 
	public int getMax() {
		return max;
	}
	
	  public void setMax(int max) { this.max = max; }
	 

}
