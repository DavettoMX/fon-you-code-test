package com.example.fonyou_test_code.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_student_calification")
public class ExamStudentCalificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long examStudentCalificationId;

    @ManyToOne
    @JoinColumn(name = "examStudentAssignationId", nullable = false)
    private ExamStudentAssignationModel examStudentAssignation;

    @Transient
    private String examName;

    @Transient
    private String studentName;

    private Double calification;

    /* Getters and setters */
    public Long getExamStudentCalificationId() {
        return examStudentCalificationId;
    }

    public void setExamStudentCalificationId(Long examStudentCalificationId) {
        this.examStudentCalificationId = examStudentCalificationId;
    }

    public ExamStudentAssignationModel getExamStudentAssignation() {
        return examStudentAssignation;
    }

    public void setExamStudentAssignation(ExamStudentAssignationModel examStudentAssignation) {
        this.examStudentAssignation = examStudentAssignation;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getCalification() {
        return calification;
    }

    public void setCalification(Double calification) {
        this.calification = calification;
    }

}
