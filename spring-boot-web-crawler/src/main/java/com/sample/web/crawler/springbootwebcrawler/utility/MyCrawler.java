package com.sample.web.crawler.springbootwebcrawler.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.sample.web.crawler.springbootwebcrawler.model.CrawlerStatisticDetails;
import com.sample.web.crawler.springbootwebcrawler.model.CrawlerStatisticModel;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

@Component
public final class MyCrawler extends WebCrawler{

	 private final static Pattern EXCLUSIONS
     = Pattern.compile(".*(\\.(css|js|xml|gif|jpg|png|mp3|mp4|zip|gz|pdf|svg|ico|icon))$");
	 
	 private static final Pattern IMG_PATTERNS = Pattern.compile(".*(\\.(jpg|jpeg|png))$");

	 private static  CrawlerStatisticModel model= null;
	 
	 public MyCrawler() {
		 
	 }
	
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
	    String urlString = url.getURL().toLowerCase();
	    return ( !EXCLUSIONS.matcher(urlString).matches() )||(IMG_PATTERNS.matcher(urlString).matches() );
	}
	@Override
	public void visit(Page page) {
		boolean isSeedUrl=false;
		CrawlerStatisticDetails details= null;
		if(model==null) {
		model=  new CrawlerStatisticModel();
		List<CrawlerStatisticDetails> detailList= new ArrayList<>();
		model.setDetails(detailList);
		isSeedUrl=true;
		}
		else
		{
			 details= new CrawlerStatisticDetails();
		}
	    String url = page.getWebURL().getURL();
	//    stats.incrementProcessedPageCount();
	    if (page.getParseData() instanceof HtmlParseData) {
	        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
	        String title = htmlParseData.getTitle();
	    //    System.out.println("title pppppp"+title);
	        Set<WebURL> links = htmlParseData.getOutgoingUrls();
	        
	        for(WebURL webURL:links) {
	        	if(!EXCLUSIONS.matcher(webURL.getURL()).matches()) {
	        	// stats.incrementTotalLinksCount(1);
	        		if(isSeedUrl)
	        			model.setTotalLinks(model.getTotalLinks()+1);
	        		
	        //	 System.out.println("Exculsions  ::" +webURL.getURL());
	        	}
	        	else if(IMG_PATTERNS.matcher(webURL.getURL()).matches()) {
	        		if(isSeedUrl)
	        			model.setTotatImages(model.getTotatImages()+1);
	        		else
	        			details.setImageCount(details.getImageCount()+1);
	        		//System.out.println(webURL.getURL());
				} /*
					 * else { //System.out.println(" Out ---  !!! "+webURL.getURL()); }
					 */
	        	if(details!=null) {
	        		details.setPageLink(url);
	        		details.setPageTitle(title);
	        		model.getDetails().add(details);
	        	}
	        }
	    }
	}
	
	public  CrawlerStatisticModel startCrawl(String url ,int depth)  {
		
		model=null;
		  File crawlStorage = new File("src/test/resources/crawler4j"); CrawlConfig
		  config = new CrawlConfig();
		  config.setCrawlStorageFolder(crawlStorage.getAbsolutePath());
		  config.setMaxDepthOfCrawling(depth); int numCrawlers = 3;
		  config.setCleanupDelaySeconds(0);
		  config.setThreadShutdownDelaySeconds(0);
		  PageFetcher pageFetcher = new PageFetcher(config); RobotstxtConfig
		  robotstxtConfig = new RobotstxtConfig(); RobotstxtServer robotstxtServer= new
		  RobotstxtServer(robotstxtConfig, pageFetcher); CrawlController controller;
		try {
			controller = new CrawlController(config, pageFetcher, robotstxtServer);
			 controller.addSeed(url);
			  CrawlController.WebCrawlerFactory<MyCrawler> factory = ()-> new
			  MyCrawler();
			  controller.start(factory, numCrawlers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		 
 	//	  System.out.println(model.toString()); 
		return model; 
		
	
	}
}

