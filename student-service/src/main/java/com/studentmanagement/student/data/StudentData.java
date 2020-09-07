package com.studentmanagement.student.data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="students")
public class StudentData {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int rollNumber;
	private String standard;
	private String section;
	private String studentId;
	private String gender;
	
	public StudentData() {
		
	}
	
	@Override
	public String toString() {
		return "StudentData [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNumber="
				+ rollNumber + ", standard=" + standard + ", section=" + section + ", studentId=" + studentId
				+ ", gender=" + gender + "]";
	}

	public StudentData(String id, String firstName, String lastName, int rollNumber, String standard, String section,
			String studentId, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNumber = rollNumber;
		this.standard = standard;
		this.section = section;
		this.studentId = studentId;
		this.gender = gender;
	}
	
	public StudentData(String firstName, String lastName, int rollNumber, String standard, String section, String studentId,
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



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
