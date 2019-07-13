package com.saha.sample.caching.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.saha.sample.caching.service.Service;

/**
 * In memory caching service
 * @author Prasenjit_Saha
 *
 * @param <T>
 */
@Component
public class CacheServiceL1<T> implements Service<T>{
    private static final int MAX_CAPACITY = 2;
    private static final Logger log = LoggerFactory.getLogger(CacheServiceL1.class);
    		
	Map<String, T> myMap;
	
	public CacheServiceL1() {
    	log.info("Starting level1 caching service..");
		// Initialize  simple LRU based cache
		myMap = new LinkedHashMap<String, T>(MAX_CAPACITY, 0.75f, true){
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, T> eldest) {
				// TODO Auto-generated method stub
				return size() > MAX_CAPACITY;
			}
		};
	}
	
	@Override
	public T get(String key) {
		return myMap.get(key);
	}
	

	@Override
	public void put(String key, T t) {
		myMap.put(key, t);
	}
}
