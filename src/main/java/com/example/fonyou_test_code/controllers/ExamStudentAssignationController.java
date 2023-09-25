package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.ExamQuestionModel;
import com.example.fonyou_test_code.services.StudentService;
import com.example.fonyou_test_code.services.ExamService;

import com.example.fonyou_test_code.models.ExamStudentAssignationModel;
import com.example.fonyou_test_code.services.ExamStudentAssignationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/examStudentAssignation")
public class ExamStudentAssignationController {

    @Autowired
    ExamStudentAssignationService examStudentAssignationService;

    @GetMapping()
    public ArrayList<ExamStudentAssignationModel> getExamStudentAssignations() {
        return examStudentAssignationService.getExamStudentAssignations();
    }

    @PostMapping()
    public ResponseEntity<ExamStudentAssignationModel> assignExamToStudent(@RequestBody ExamStudentAssignationModel examStudentAssignationModel) {
        return ResponseEntity.ok(this.examStudentAssignationService.assignExamToStudent(examStudentAssignationModel));
    }
}
