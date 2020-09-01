package com.studentmanagement.studentservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.studentmanagement.studentservice.model.Student;


public interface StudentRepository extends MongoRepository<Student,String>{
	List<Student> findStudentByDepartment(String department);
}
