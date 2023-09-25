package com.example.fonyou_test_code.controllers;

import com.example.fonyou_test_code.models.StudentModel;
import com.example.fonyou_test_code.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public ArrayList<StudentModel> getStudents() {
        return (ArrayList<StudentModel>) studentService.getStudents();
    }

    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student) {
        return this.studentService.saveStudent(student);
    }

}
