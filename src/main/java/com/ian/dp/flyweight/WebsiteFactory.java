package com.ian.dp.flyweight;

import java.util.HashMap;
import java.util.Map;

public class WebsiteFactory {

	private Map<String, Website> websites = new HashMap<>();
	
	public Website getWebsiteCatalog(String key){
		if (websites.get(key) == null) {
			websites.put(key, new ConcreteWebsite(key));
		}
		return websites.get(key);
	}
	
	public int getWebsiteCount(){
		return websites.size();
	}
}
