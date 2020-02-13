package com.sample.web.crawler.springbootwebcrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.web.crawler.springbootwebcrawler.model.CrawlerStatisticModel;
import com.sample.web.crawler.springbootwebcrawler.utility.MyCrawler;

@Service
public class WebCrawlerServiceImpl {
	
	@Autowired
	MyCrawler myCrawler;

	public CrawlerStatisticModel getCrawledData(String seedUrl, int crawlingDepth) {
	return	myCrawler.startCrawl(seedUrl, crawlingDepth);
	}

}
