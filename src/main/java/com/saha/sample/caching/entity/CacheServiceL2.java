package com.saha.sample.caching.entity;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saha.sample.caching.service.Service;




//file based caching service
@Component
public class CacheServiceL2 <T> implements Service<T>{

	@Autowired
	L2CacheManager l2cacheManager;
	
	//load from file
	@Override
	public T get(String key) {
		// TODO Auto-generated method stub
		try {
			return (T)l2cacheManager.getRecordFromL2Cache(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void put(String key, T value) {
		// TODO Auto-generated method stub
		
	}

}
