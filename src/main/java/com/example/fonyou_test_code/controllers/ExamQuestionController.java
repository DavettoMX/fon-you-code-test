package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.models.ExamQuestionModel;
import com.example.fonyou_test_code.services.ExamQuestionService;
import com.example.fonyou_test_code.services.ExamService;
import com.example.fonyou_test_code.services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam-question")
public class ExamQuestionController {

    @Autowired
    ExamQuestionService examQuestionService;

    @GetMapping()
    public ArrayList<ExamQuestionModel> getExamQuestions() {
        return examQuestionService.getExamQuestions();
    }

    @PostMapping()
    public ResponseEntity<ExamQuestionModel> saveExamQuestion(@RequestBody ExamQuestionModel examQuestion) {
        return ResponseEntity.ok(this.examQuestionService.saveExamQuestion(examQuestion));
    }

}
