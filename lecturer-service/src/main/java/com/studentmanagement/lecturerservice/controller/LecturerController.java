package com.studentmanagement.lecturerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentmanagement.lecturerservice.entity.CourseList;
import com.studentmanagement.lecturerservice.entity.Lecturer;
import com.studentmanagement.lecturerservice.entity.LecturerList;
import com.studentmanagement.lecturerservice.entity.StudentList;
import com.studentmanagement.lecturerservice.repository.LecturerRepository;

@RestController
@RequestMapping(value="/lecturers")
public class LecturerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	@GetMapping
	public LecturerList getAllLecturer(){
		List<Lecturer> lecturers=lecturerRepository.findAll();
		LecturerList lecturerList=new LecturerList();
		lecturerList.setLecturerList(lecturers);
		return lecturerList;
	}
	
	@GetMapping(value="/students")
	public StudentList getStudents() {
		StudentList studentList=restTemplate.getForObject("http://localhost:8080/students", StudentList.class);
		return studentList;
	}
	
	@GetMapping(value="/courses")
	public CourseList getCourses() {
		CourseList courseList=restTemplate.getForObject("http://localhost:8084/courses", CourseList.class);
		return courseList;
	}
	
	@PostMapping
	public Lecturer createLecturer(@RequestBody Lecturer lecturer) {
		lecturerRepository.save(lecturer);
		return lecturer;
	}
	
	@DeleteMapping(value="/id/{id}")
	public String deleteLecturer(@PathVariable("id") String id) {
		Optional<Lecturer> lecturer=lecturerRepository.findById(id);
		if(lecturer.isPresent()) {
			lecturerRepository.delete(lecturer.get());;
			return "Successfully Deleted";
		}else {
			return "Not found";
		}
	}
}
