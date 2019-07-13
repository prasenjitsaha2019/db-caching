package com.saha.sample.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saha.sample.caching.dao.StudentService;
import com.saha.sample.caching.domain.Student;
import com.saha.sample.caching.entity.L2CacheManager;

@SpringBootApplication
public class DbCachingApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DbCachingApplication.class);
	
	@Autowired
	StudentService<Student> studentService;
	@Autowired
	L2CacheManager l2CacheManager;
	
	public static void main(String[] args) {
		SpringApplication.run(DbCachingApplication.class, args);

	}

    @Override
    public void run(String... args) throws InterruptedException {
        Thread.sleep(5000);
    	log.info("Starting application..\n");
        log.info("L2CAche enable? - " + l2CacheManager.isEnableL2Cache());
        
    	Student s = studentService.get("Aarika");
    	log.info(s.toString() + "\n");
    	
    	s = studentService.get("Aaren");
    	log.info(s.toString() + "\n");   	
    	
    	s = studentService.get("Aarika");
    	log.info(s.toString() + "\n");
    	s = studentService.get("Abagail");
    	
    	log.info(s.toString() + "\n");
    	s = studentService.get("Abagail");
    	
    	log.info(s.toString() + "\n");
    	
    	log.info("Adding new student Deepak: " + "\n");
    	studentService.put(new Student("Deepak", "Dutta", "12031996", 78, "Biology"));
    	
    	s = studentService.get("Deepak");
    	log.info(s.toString() + "\n");
    	
    	log.info("Closing application.");

    }
    
}
