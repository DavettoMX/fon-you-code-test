package com.example.fonyou_test_code.repositories;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.models.StudentAnswerModel;
import com.example.fonyou_test_code.models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAnswerRepository extends CrudRepository<StudentAnswerModel, Long> {
}
