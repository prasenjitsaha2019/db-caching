package com.saha.sample.caching.entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.saha.sample.caching.domain.Student;

@Component
public class L2CacheManager {

	@Value("${mycache.H2.enable}")		
	private boolean enableL2Cache;
	
	@Value("${mycache.record.max}")
	private int MAX_RECORD;
	
	@Value("${mycache.filenane}")
	private String  fileName;
	
	@Value("${mycache.refresh.interval}")
	private int refreshInterval;

	public boolean isEnableL2Cache() {
		return enableL2Cache;
	}

	public int getMAX_RECORD() {
		return MAX_RECORD;
	}

	public String getFileName() {
		return fileName;
	}

	public int getRefreshInterval() {
		return refreshInterval;
	}
		
	public Object getRecordFromL2Cache(String fname) throws IOException {
		File file = ResourceUtils.getFile("classpath:" + fileName);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		for(String s : lines) {
			if (s.startsWith(fname+"=")) {
				return createObject(s.split("=")[1]);
			}
		}
		return null;
	}
	
	/*
	 * Refreshes the cache at specified interval with MAX_RECORD elements
	 */
	public void refreshL2Cache() {
		
	}
	
	private Object createObject(String s) {
		
		String props[] = s.split(",");
	    return new Student(Integer.valueOf(props[0]), props[1], props[2], props[3], Integer.valueOf(props[4]), props[5]);
	}
}
