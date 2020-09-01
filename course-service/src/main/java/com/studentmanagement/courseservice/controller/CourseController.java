package com.studentmanagement.courseservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentmanagement.courseservice.model.Course;
import com.studentmanagement.courseservice.model.CourseList;
import com.studentmanagement.courseservice.model.LecturerList;
import com.studentmanagement.courseservice.repository.CourseRepository;

@RestController
@RequestMapping(value="/courses")
public class CourseController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public CourseList getAllCourses() {
		List<Course> courses=courseRepository.findAll();
		CourseList courseList=new CourseList();
		courseList.setCourses(courses);
		return courseList;
	}
	
	@GetMapping(value="Lecturer")
	public LecturerList getAllLecturer() {
		LecturerList lecturerList=restTemplate.getForObject("http://localhost:8081/lecturer", LecturerList.class);
		return lecturerList;
	}
	
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		courseRepository.save(course);
		return course;
	}
	
	@GetMapping(value="/id/{id}")
	public Course getCourse(@PathVariable("id") String id) {
		Optional<Course> course=courseRepository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}else {
			return new Course();
		}
	}
	
	@DeleteMapping(value="/id/{id}")
	public String deleteCourse(@PathVariable("id") String id) {
		Optional<Course> course=courseRepository.findById(id);
		if(course.isPresent()) {
			courseRepository.delete(course.get());
			return "Successfully deleted";
		}else {
			return "Not found";
		}
	}
	
}
