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
    @JoinColumn(name = "examQuestionId", nullable = false)
    private ExamQuestionModel examQuestion;

    @Transient
    private String examQuestionText;

    @Transient
    private String studentName;

    @Column(nullable = false)
    private Integer studentAnswer;

    @Column(nullable = false)
    private Float studentScore;

    @Column(nullable = false)
    private Boolean isCorrect;


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

    public ExamQuestionModel getExamQuestion() {
        return examQuestion;
    }

    public String getExamQuestionText() {
        return examQuestionText;
    }

    public void setExamQuestionText(String examQuestionText) {
        this.examQuestionText = examQuestionText;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setExamQuestion(ExamQuestionModel examQuestion) {
        this.examQuestion = examQuestion;
    }

    public Integer getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(Integer studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public Float getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Float studentScore) {
        this.studentScore = studentScore;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

}
