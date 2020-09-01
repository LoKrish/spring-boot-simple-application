package com.studentmanagement.lecturerservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lecturer {
	@Id
	String id;
	String name;
	String department;
	
	Lecturer(){
		
	}
	
	Lecturer(String id,String name,String department){
		this.id=id;
		this.name=name;
		this.department=department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
