package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.StudentAnswerModel;
import com.example.fonyou_test_code.services.StudentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/student-answer")
public class StudentAnswerController {

    @Autowired
    StudentAnswerService studentAnswerService;

    @GetMapping()
    public ArrayList<StudentAnswerModel> getStudentAnswers() {
        return studentAnswerService.getStudentAnswers();
    }

    @PostMapping()
    public StudentAnswerModel saveStudentAnswer(StudentAnswerModel studentAnswer) {
        return this.studentAnswerService.saveStudentAnswer(studentAnswer);
    }
}
