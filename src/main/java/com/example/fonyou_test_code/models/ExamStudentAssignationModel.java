package com.example.fonyou_test_code.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "exam_student_assignation")
public class ExamStudentAssignationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long examStudentAssignationId;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private StudentModel student;

    @Transient
    private String examName;

    @Transient
    private String studentName;

    private ZonedDateTime examDate;

    /* Getters and setters */
    public Long getExamStudentAssignationId() {
        return examStudentAssignationId;
    }

    public void setExamStudentAssignationId(Long examStudentAssignationId) {
        this.examStudentAssignationId = examStudentAssignationId;
    }

    public ExamModel getExam() {
        return exam;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public ZonedDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(ZonedDateTime examDate) {
        this.examDate = examDate;
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

    public Long getStudentId() {
        return this.student.getStudentId();
    }

    public void setStudentId(Long studentId) {
        this.student.setStudentId(studentId);
    }
}
