package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.StudentAnswerModel;
import com.example.fonyou_test_code.repositories.StudentAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentAnswerService {

    @Autowired
    StudentAnswerRepository studentAnswerRepository;

    public ArrayList<StudentAnswerModel> getStudentAnswers() {
        try {
            return (ArrayList<StudentAnswerModel>) studentAnswerRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public StudentAnswerModel saveStudentAnswer(StudentAnswerModel studentAnswer) {
        return studentAnswerRepository.save(studentAnswer);
    }

}
