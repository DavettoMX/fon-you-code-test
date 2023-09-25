package com.example.fonyou_test_code.repositories;

import com.example.fonyou_test_code.models.ExamModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends CrudRepository<ExamModel, Long> {

    ExamModel findByExamName(String examName);
}
