package com.sample.web.crawler.springbootwebcrawler.model;

public class CrawlerStatistics {
	private int processedPageCount = 0;
    private int totalLinksCount = 0;
    private int totatImageCount = 0;
     
    public void incrementProcessedPageCount() {
        processedPageCount++;
    }
    public void incrementTotalImageCount() {
    	totatImageCount++;
    }
     
    public int getTotatImageCount() {
		return totatImageCount;
	}
	public void setTotatImageCount(int totatImageCount) {
		this.totatImageCount = totatImageCount;
	}
	public void incrementTotalLinksCount(int linksCount) {
        totalLinksCount += linksCount;
    }

	public int getProcessedPageCount() {
		return processedPageCount;
	}

	public void setProcessedPageCount(int processedPageCount) {
		this.processedPageCount = processedPageCount;
	}

	public int getTotalLinksCount() {
		return totalLinksCount;
	}

	public void setTotalLinksCount(int totalLinksCount) {
		this.totalLinksCount = totalLinksCount;
	}
}
