package com.example.fonyou_test_code.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "exam_question")
public class ExamQuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long examQuestionId;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private ExamModel exam;

    @Transient
    private String examName;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private Integer correctAnswer;

    @Column(nullable = false)
    private Float questionValue;

    @Column(nullable = false)
    private Integer option1;

    @Column(nullable = false)
    private Integer option2;

    @Column(nullable = false)
    private Integer option3;

    @Column(nullable = false)
    private Integer option4;



    /* Getters and setters */

    public Long getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(Long examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public ExamModel getExam() {
        return exam;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamId() {
        return exam.getExamId().toString();
    }

    public void setExamId(String examId) {
        this.exam.setExamId(Long.parseLong(examId));
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Float getQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(Float questionValue) {
        this.questionValue = questionValue;
    }

    public Integer getOption1() {
        return option1;
    }

    public void setOption1(Integer option1) {
        this.option1 = option1;
    }

    public Integer getOption2() {
        return option2;
    }

    public void setOption2(Integer option2) {
        this.option2 = option2;
    }

    public Integer getOption3() {
        return option3;
    }

    public void setOption3(Integer option3) {
        this.option3 = option3;
    }

    public Integer getOption4() {
        return option4;
    }

    public void setOption4(Integer option4) {
        this.option4 = option4;
    }

}
