package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.services.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @GetMapping()
    public ArrayList<ExamModel> getExam() {
        return examService.getExam();
    }

    @GetMapping("/get-exam-id-by-exam-name")
    public ExamModel getExamIdByExamName(String examName) {
        return this.examService.getExamIdByExamName(examName);
    }

    @PostMapping()
    public ExamModel saveExam(@RequestBody ExamModel exam) {
        return this.examService.saveExam(exam);
    }

}
