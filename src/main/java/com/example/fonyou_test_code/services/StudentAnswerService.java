package com.example.fonyou_test_code.services;

import com.example.fonyou_test_code.models.ExamQuestionModel;
import com.example.fonyou_test_code.models.StudentAnswerModel;
import com.example.fonyou_test_code.models.StudentModel;
import com.example.fonyou_test_code.repositories.ExamQuestionRepository;
import com.example.fonyou_test_code.repositories.StudentAnswerRepository;
import com.example.fonyou_test_code.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentAnswerService {

    @Autowired
    StudentAnswerRepository studentAnswerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    public ArrayList<StudentAnswerModel> getStudentAnswers() {
        try {
            return (ArrayList<StudentAnswerModel>) studentAnswerRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public StudentAnswerModel saveStudentAnswer(StudentAnswerModel studentAnswer) {
        String studentName = studentAnswer.getStudentName();
        String examQuestionText = studentAnswer.getExamQuestionText();

        StudentModel student = studentRepository.findByStudentName(studentName);
        ExamQuestionModel examQuestion = examQuestionRepository.findByQuestionText(examQuestionText);

        if (student != null && examQuestion != null) {
            studentAnswer.setStudent(student);
            studentAnswer.setExamQuestion(examQuestion);
            return studentAnswerRepository.save(studentAnswer);
        } else {
            return null;
        }
    }

}
