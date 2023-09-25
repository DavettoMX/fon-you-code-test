package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.ExamStudentCalificationModel;
import com.example.fonyou_test_code.services.ExamStudentCalificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/examStudentCalification")
public class ExamStudentCalificationController {

    @Autowired
    ExamStudentCalificationService examStudentCalificationService;

    @GetMapping()
    public ArrayList<ExamStudentCalificationModel> getExamStudentCalifications() {
        return examStudentCalificationService.getExamStudentCalifications();
    }

    @PostMapping()
    public ResponseEntity<ExamStudentCalificationModel> saveExamStudentCalification(@RequestBody ExamStudentCalificationModel examStudentCalificationModel) {
        return ResponseEntity.ok(this.examStudentCalificationService.calificateUserExam(examStudentCalificationModel));
    }
}
