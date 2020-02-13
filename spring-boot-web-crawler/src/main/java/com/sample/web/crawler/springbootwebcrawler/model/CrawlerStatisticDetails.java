package com.sample.web.crawler.springbootwebcrawler.model;

public class CrawlerStatisticDetails {
	
	private String pageTitle;
	private String pageLink;
	private int imageCount;
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public String getPageLink() {
		return pageLink;
	}
	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}
	public int getImageCount() {
		return imageCount;
	}
	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}
	@Override
	public String toString() {
		return "CrawlerStatisticDetails [pageTitle=" + pageTitle + ", pageLink=" + pageLink + ", imageCount="
				+ imageCount + "]";
	}
	
	
}
