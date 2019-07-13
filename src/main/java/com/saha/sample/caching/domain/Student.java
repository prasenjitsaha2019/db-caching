package com.saha.sample.caching.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private long id;
	private String fname;
	private String lname;
	private String dobirth;
	private int score;
	private String major;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDobirth() {
		return dobirth;
	}
	public void setDobirth(String dobirth) {
		this.dobirth = dobirth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", dobirth=" + dobirth + ", score="
				+ score + ", major=" + major + "]";
	}
	
	public Student() {
		super();
	}
	
	public Student(String fname, String lname, String dobirth, int score, String major) {
		this.fname = fname;
		this.lname = lname;
		this.dobirth = dobirth;
		this.score = score;
		this.major = major;
	}		
	
	public Student(int id, String fname, String lname, String dobirth, int score, String major) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dobirth = dobirth;
		this.score = score;
		this.major = major;
	}
}
