package com.studentmanagement.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="students")
public class Student {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int rollNumber;
	private String standard;
	private String section;
	private String studentId;
	private String gender;
	
	public Student(String firstName, String lastName, int rollNumber, String standard, String section, String studentId,
			String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNumber = rollNumber;
		this.standard = standard;
		this.section = section;
		this.studentId = studentId;
		this.gender = gender;
	}
	
	public Student(){
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getStandard() {
		return standard;
	}
	
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
}
