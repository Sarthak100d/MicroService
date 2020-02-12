package com.microservices.currency.calculation.currencycalculationservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currency.calculation.currencycalculationservice.model.CurrencyConversionBean;
import com.microservices.currency.calculation.currencycalculationservice.service.CurrencyExchangeServiceInterface;

@RestController
public class CurrencyConversionController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	CurrencyExchangeServiceInterface currencyExchangeServiceInterface;
	
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from , @PathVariable String to , @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> map= new HashMap<>();
		map.put("from", from);
		map.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,map);
		CurrencyConversionBean currencyConversionBean=responseEntity.getBody();
		
		return new CurrencyConversionBean(currencyConversionBean.getId(),from,to,
				currencyConversionBean.getConversionMultiple(),
				quantity
				,quantity.multiply(currencyConversionBean.getConversionMultiple()),currencyConversionBean.getPort());
	}
	
	@GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from , @PathVariable String to , @PathVariable BigDecimal quantity) {
		CurrencyConversionBean currencyConversionBean=	currencyExchangeServiceInterface.retrieveExchangeValue(from, to);
		return new CurrencyConversionBean(currencyConversionBean.getId(),from,to,
				currencyConversionBean.getConversionMultiple(),
				quantity
				,quantity.multiply(currencyConversionBean.getConversionMultiple()),currencyConversionBean.getPort());
	}
}
