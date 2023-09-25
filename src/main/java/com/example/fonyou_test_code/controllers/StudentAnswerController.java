package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.StudentAnswerModel;
import com.example.fonyou_test_code.services.StudentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public StudentAnswerModel saveStudentAnswer(@RequestBody StudentAnswerModel studentAnswer) {
        return ResponseEntity.ok(studentAnswerService.saveStudentAnswer(studentAnswer)).getBody();
    }
}
