package com.studentmanagement.lecturerservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Course {
	
	@Id
	String id;
	String name;
	int startedYear;
	String description;
	
	public Course(){
		
	}
	
	public Course(String name,int startedYear,String description){
		this.name=name;
		this.startedYear=startedYear;
		this.description=description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartedYear() {
		return startedYear;
	}

	public void setStartedYear(int startedYear) {
		this.startedYear = startedYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
