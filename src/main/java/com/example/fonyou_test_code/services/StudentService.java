package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.StudentModel;
import com.example.fonyou_test_code.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentModel> getStudents() {

        try {
            return (List<StudentModel>) studentRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public StudentModel saveStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    public StudentModel getStudentById(Long id) {
        try {
            return studentRepository.findById(id).orElse(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public StudentModel getStudentIdByStudentName(String studentName) {
        try {
            return studentRepository.findByStudentName(studentName);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
