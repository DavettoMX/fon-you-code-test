package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.*;
import com.example.fonyou_test_code.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamStudentCalificationService {

    @Autowired
    ExamStudentCalificationRepository examStudentCalificationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    @Autowired
    private StudentAnswerRepository studentAnswerRepository;

    @Autowired
    private ExamStudentAssignationRepository examStudentAssignationRepository;


    public ArrayList<ExamStudentCalificationModel> getExamStudentCalifications() {
        try {
            return (ArrayList<ExamStudentCalificationModel>) examStudentCalificationRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ExamStudentCalificationModel calificateUserExam(ExamStudentCalificationModel examStudentCalification) {
        String examName = examStudentCalification.getExamName();
        String studentName = examStudentCalification.getStudentName();

        ExamModel exam = examRepository.findByExamName(examName);
        StudentModel student = studentRepository.findByStudentName(studentName);

        Long examId = exam.getExamId();
        Long studentId = student.getStudentId();

        ExamStudentAssignationModel examStudentAssignation = examStudentAssignationRepository.findByExam_ExamIdAndStudent_StudentId(examId, studentId);
        examStudentCalification.setExamStudentAssignation(examStudentAssignation);

        System.out.println(examStudentCalification.getExamStudentAssignation());

        Double calification = 0.0;

        List<StudentAnswerModel> studentAnswers = studentAnswerRepository.findAllByStudent_StudentIdAndExamQuestion_Exam_ExamId(studentId, examId);

        for (StudentAnswerModel studentAnswer : studentAnswers) {

            Boolean isCorrectAnswer = studentAnswer.getIsCorrect();

            if (isCorrectAnswer) {
                Float studentAnswerText = studentAnswer.getStudentScore();
                calification += studentAnswerText;
            }
        }

        examStudentCalification.setCalification(calification);
        return examStudentCalificationRepository.save(examStudentCalification);
    }
}
