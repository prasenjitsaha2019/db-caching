package com.saha.sample.caching.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saha.sample.caching.domain.Student;
import com.saha.sample.caching.entity.CacheServiceL1;
import com.saha.sample.caching.entity.CacheServiceL2;
import com.saha.sample.caching.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService<Student> {

	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CacheServiceL1<Student> cacheServiceL1;
	
	@Autowired
	CacheServiceL2<Student> cacheServiceL2;
	
	@Override
	public Student get(String name) {
		
		//if found in cache return else go to db;
		//first check L1 Cache
		Student student = (Student)cacheServiceL1.get(name);
		if(student!=null) {
			log.info(name + " - Got from Level1 Cache!");
			return student;
		}
		
		//If L2cache is enabled check L2 cache, if found return
		student = (Student)cacheServiceL2.get(name);
		if(student!=null) {
			log.info(name +  " - Got from Level2 Cache!");
			cacheServiceL1.put(name, student);
			return student;
		}
		
		log.info(name + " - Got from DB!");
		Student s1 = studentRepository.getStudentByFname(name);
		cacheServiceL1.put(name, s1);
		return studentRepository.getStudentByFname(name);
		
	}

	@Override
	public void put(Student student) {
				
		studentRepository.save(student);
		//add to cache service once saved
		cacheServiceL1.put(student.getFname(), student);

	}

}
