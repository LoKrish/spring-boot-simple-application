package com.studentmanagement.student.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentmanagement.student.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	@Query(value = "{ 'gender' : ?0 }", fields = "{'firstName' : 1 , 'lastName' : 1, 'id' : 0}")
	List<String> getStudentByGender(String gender);

	@Query(value = "{ 'rollNumber':  ?0 }", fields = "{'firstName' : 1 , 'lastName' : 1, 'id' : 0}")
	List<String> getStudentByRollNumber(int rollNumber);

	@Query(value = "{ 'standard' : ?0 ,'section' : ?1 }", fields = "{'firstName' : 1 , 'lastName' : 1, 'id' : 0}")
	List<String> getStudentByStandardAndSection(String standard, String section);

	@Query(value = "{}", fields = "{'firstName':1, 'id' : 0}")
	List<String> getStudentFirstName();
}
