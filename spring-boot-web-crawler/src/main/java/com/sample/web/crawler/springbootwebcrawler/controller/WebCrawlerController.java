package com.sample.web.crawler.springbootwebcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.web.crawler.springbootwebcrawler.service.WebCrawlerServiceImpl;

@RestController
public class WebCrawlerController {
	
	
	@Autowired
	WebCrawlerServiceImpl webCrawlerServiceImpl;
	@GetMapping("/web/crawler/{url}")
	public Object getUrlList(@PathVariable String url,@RequestParam int depth) {
		return webCrawlerServiceImpl.getCrawledData(url,depth);
	}
	

}
