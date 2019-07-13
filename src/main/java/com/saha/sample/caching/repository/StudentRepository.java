package com.saha.sample.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saha.sample.caching.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public Student getStudentByFname(final String name);
	
}
