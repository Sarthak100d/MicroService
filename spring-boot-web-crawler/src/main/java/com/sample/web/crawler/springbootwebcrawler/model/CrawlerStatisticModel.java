package com.sample.web.crawler.springbootwebcrawler.model;

import java.util.List;

public class CrawlerStatisticModel {
    private int totalLinks = 0;
    private int totatImages = 0;
    
    private List<CrawlerStatisticDetails> details;

	public int getTotalLinks() {
		return totalLinks;
	}

	public void setTotalLinks(int totalLinks) {
		this.totalLinks = totalLinks;
	}

	public int getTotatImages() {
		return totatImages;
	}

	public void setTotatImages(int totatImages) {
		this.totatImages = totatImages;
	}

	public List<CrawlerStatisticDetails> getDetails() {
		return details;
	}

	public void setDetails(List<CrawlerStatisticDetails> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "CrawlerStatisticModel [totalLinks=" + totalLinks + ", totatImages=" + totatImages + ", details="
				+ details + "]";
	} 
    
  
}
