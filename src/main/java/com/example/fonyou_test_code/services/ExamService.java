package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.ExamModel;

import com.example.fonyou_test_code.repositories.ExamQuestionRepository;
import com.example.fonyou_test_code.repositories.ExamRepository;
import com.example.fonyou_test_code.repositories.StudentAnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    public ArrayList<ExamModel> getExam() {
        try {
            return (ArrayList<ExamModel>) examRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ExamModel getExamIdByExamName(String examName) {
        try {
            return examRepository.findByExamName(examName);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ExamModel saveExam(ExamModel exam) {
        return examRepository.save(exam);
    }


}
