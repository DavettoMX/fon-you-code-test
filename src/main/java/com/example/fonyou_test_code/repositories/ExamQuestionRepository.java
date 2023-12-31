package com.example.fonyou_test_code.repositories;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.models.ExamQuestionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionRepository extends CrudRepository<ExamQuestionModel, Long> {

    List<ExamQuestionModel> findByExam(ExamModel exam);

    ExamQuestionModel findByQuestionText(String questionText);
}
