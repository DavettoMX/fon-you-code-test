package com.example.fonyou_test_code.repositories;

import com.example.fonyou_test_code.models.ExamStudentAssignationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamStudentAssignationRepository extends CrudRepository<ExamStudentAssignationModel, Long> {
}
