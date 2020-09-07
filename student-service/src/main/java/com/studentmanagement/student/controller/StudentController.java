package com.studentmanagement.student.controller;

import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentmanagement.student.model.CourseList;
import com.studentmanagement.student.model.LecturerList;
import com.studentmanagement.student.model.Student;
import com.studentmanagement.student.model.StudentName;
import com.studentmanagement.student.model.Students;
import com.studentmanagement.student.repository.StudentRepository;
import com.studentmanagement.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public Students getAllStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/gender/")
	public List<StudentName> getStudentByGender(@RequestParam(name = "gender") String gender) throws JSONException {
		return studentService.getStudentByGender(gender);
	}

	@GetMapping("/firstName/")
	public String isTheStudentPresent(@RequestParam(name = "firstName") String firstName) throws JSONException {
		return studentService.isStudentPresent(firstName);
	}

	@GetMapping("/standard/section/")
	public List<StudentName> getDepartmentStudents(@RequestParam(name = "standard") String standard,
			@RequestParam(name = "section") String section) throws JSONException {
		return studentService.getStudentByStandardAndSection(standard, section);
	}

	@GetMapping("/rollNumber/")
	public List<StudentName> getStudentByRollNumber(@RequestParam(name = "rollNumber") int rollNumber)
			throws JSONException {
		return studentService.getStudentByRollNumber(rollNumber);
	}

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

}
