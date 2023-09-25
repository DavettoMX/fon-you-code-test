package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.models.ExamQuestionModel;

import com.example.fonyou_test_code.repositories.ExamQuestionRepository;
import com.example.fonyou_test_code.repositories.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamQuestionService {

    @Autowired
    ExamQuestionRepository examQuestionRepository;

    @Autowired
    private ExamRepository examRepository;

    public ArrayList<ExamQuestionModel> getExamQuestions() {
        try
        {
            return (ArrayList<ExamQuestionModel>) examQuestionRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ExamQuestionModel saveExamQuestion(ExamQuestionModel examQuestion) {
        String examName = examQuestion.getExamName();
        ExamModel exam = examRepository.findByExamName(examName);

        if (exam != null)
        {
            examQuestion.setExam(exam);
            return examQuestionRepository.save(examQuestion);
        }
        else
        {
            return null;
        }
    }

}
