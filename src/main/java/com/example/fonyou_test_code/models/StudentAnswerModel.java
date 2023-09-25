package com.example.fonyou_test_code.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student_answer")
public class StudentAnswerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long studentAnswerId;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private ExamQuestionModel question;

    @Column(nullable = false)
    private String studentAnswer;

    /* Getters and setters */
    public Long getStudentAnswerId() {
        return studentAnswerId;
    }

    public void setStudentAnswerId(Long studentAnswerId) {
        this.studentAnswerId = studentAnswerId;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public ExamQuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(ExamQuestionModel question) {
        this.question = question;
    }

    public String getStudentAnswer() { return studentAnswer; }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

}
