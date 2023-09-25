package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.models.ExamStudentAssignationModel;

import com.example.fonyou_test_code.models.StudentModel;
import com.example.fonyou_test_code.repositories.ExamRepository;
import com.example.fonyou_test_code.repositories.StudentRepository;
import com.example.fonyou_test_code.repositories.ExamStudentAssignationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.util.ArrayList;

@Service
public class ExamStudentAssignationService {

    @Autowired
    ExamStudentAssignationRepository examStudentAssignationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;


    public ArrayList<ExamStudentAssignationModel> getExamStudentAssignations() {
        try {
            return (ArrayList<ExamStudentAssignationModel>) examStudentAssignationRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public ExamStudentAssignationModel assignExamToStudent(ExamStudentAssignationModel examStudentAssignation) {
        String examName = examStudentAssignation.getExamName();
        String studentName = examStudentAssignation.getStudentName();

        ExamModel exam = examRepository.findByExamName(examName);
        StudentModel student = studentRepository.findByStudentName(studentName);

        if (exam != null && student != null) {
            examStudentAssignation.setExam(exam);
            examStudentAssignation.setStudent(student);
            examStudentAssignation.setExamDateStudentTimezone(ZonedDateTime.now(ZoneId.of("America/Bogota")));

            return examStudentAssignationRepository.save(examStudentAssignation);
        } else {
            return null;
        }
    }

}
