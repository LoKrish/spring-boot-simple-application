package com.studentmanagement.lecturerservice.entity;

import java.util.List;

public class LecturerList {
	
	private List<Lecturer> lecturers;

	public List<Lecturer> getLecturerList() {
		return lecturers;
	}

	public void setLecturerList(List<Lecturer> lecturerList) {
		this.lecturers = lecturerList;
	}
	
}
