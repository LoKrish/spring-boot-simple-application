package com.studentmanagement.studentservice.controller;

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

import com.studentmanagement.studentservice.model.CourseList;
import com.studentmanagement.studentservice.model.LecturerList;
import com.studentmanagement.studentservice.model.Student;
import com.studentmanagement.studentservice.model.StudentList;
import com.studentmanagement.studentservice.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public StudentList getAllStudents(){
		List<Student> students=studentRepository.findAll();
		StudentList studentsList=new StudentList();
		studentsList.setStudents(students);
		return studentsList;
	}
	
	@GetMapping("/lecturers")
	public LecturerList getLecturer() {
		LecturerList lecturers=restTemplate.getForObject("http://localhost:8081/lecturers", LecturerList.class);
		return lecturers;
	}
	
	@GetMapping(value="/courses")
	public CourseList getCourses() {
		CourseList courseList=restTemplate.getForObject("http://localhost:8084/courses", CourseList.class);
		return courseList;
	}
	
	@GetMapping(value="/id/{id}")
	public Student getStudent(@PathVariable("id") String id) {
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			return new Student();
		}
	}
	
	@GetMapping(value="/department/{department}")
	public List<Student> getDepartmentStudents(@PathVariable("department") String department){
		List<Student> students=studentRepository.findStudentByDepartment(department);
		return students;
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student ) {
		studentRepository.save(student);
		return student;
	}
	
	@DeleteMapping(value="/id/{id}")
	public String deleteStudent(@PathVariable("id") String id) {
		studentRepository.deleteById(id);
		return "Successfully deleted";
	}
	
}
