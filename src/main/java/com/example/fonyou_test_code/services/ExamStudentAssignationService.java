package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.*;

import com.example.fonyou_test_code.repositories.ExamRepository;
import com.example.fonyou_test_code.repositories.StudentRepository;
import com.example.fonyou_test_code.repositories.ExamStudentAssignationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

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

        ZonedDateTime examDate = exam.getExamDate();
        String studentTimeZone = student.getStudentTimezone();

        ZonedDateTime examDateInStudentTimeZone = examDate.withZoneSameInstant(ZoneId.of(studentTimeZone));

        examStudentAssignation.setExamDate(examDateInStudentTimeZone);
        examStudentAssignation.setExam(exam);
        examStudentAssignation.setStudent(student);

        return examStudentAssignationRepository.save(examStudentAssignation);
    }

}
