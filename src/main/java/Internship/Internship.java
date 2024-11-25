package Internship;

import Company.Company;

public class Internship {
	private int internshipId;
	private String major;
	private String type;
	private String title;
	public Internship() {
		
	}
	public Internship(int id, String major, String type, String title) {
		internshipId = id;
		this.major = major;
		this.type = type;
		this.title = title; 
	}
	public String getMajor() {
		return major;
	}
	public String getType() {
		return type;
	}
	public String getTitle() {
		return title;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
