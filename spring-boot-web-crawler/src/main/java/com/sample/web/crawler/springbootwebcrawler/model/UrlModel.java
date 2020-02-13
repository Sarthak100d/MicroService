package com.sample.web.crawler.springbootwebcrawler.model;


public class UrlModel {
		private String seedUrl;
		private int crawlingDepth;
		public String getSeedUrl() {
			return seedUrl;
		}
		public void setSeedUrl(String seedUrl) {
			this.seedUrl = seedUrl;
		}
		public int getCrawlingDepth() {
			return crawlingDepth;
		}
		public void setCrawlingDepth(int crawlingDepth) {
			this.crawlingDepth = crawlingDepth;
		}	
}
