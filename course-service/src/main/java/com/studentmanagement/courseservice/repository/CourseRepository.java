package com.studentmanagement.courseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.studentmanagement.courseservice.model.Course;

public interface CourseRepository extends MongoRepository<Course,String>{

}
