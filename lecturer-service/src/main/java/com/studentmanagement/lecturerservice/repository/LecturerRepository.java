package com.studentmanagement.lecturerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.studentmanagement.lecturerservice.entity.Lecturer;

public interface LecturerRepository extends MongoRepository<Lecturer,String>{

}
