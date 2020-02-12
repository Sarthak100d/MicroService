package com.microservices.currency.exchange.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currency.exchange.currencyexchangeservice.model.ExchangeValue;
import com.microservices.currency.exchange.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	ExchangeValueRepository exchangeValueRepository;
		@Autowired
		Environment env;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from ,@PathVariable String to) {
		/*
		 * ExchangeValue exchangeValue= new
		 * ExchangeValue(1000L,"USD","INR",BigDecimal.valueOf(65));
		 * exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")))
		 * ;
		 */
		ExchangeValue exchangeValue= exchangeValueRepository.findByFromAndTo(from, to);
		logger.info("{}",exchangeValue);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}

}
