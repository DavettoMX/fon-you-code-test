package com.example.fonyou_test_code.repositories;

import com.example.fonyou_test_code.models.StudentModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {

    StudentModel findByStudentName(String studentName);

}
