package com.example.fonyou_test_code.repositories;

import com.example.fonyou_test_code.models.ExamStudentCalificationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamStudentCalificationRepository extends CrudRepository<ExamStudentCalificationModel, Long> {
}
