package com.example.fonyou_test_code.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exam")
public class ExamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long examId;

    @Column(unique = true, nullable = false)
    private String examName;

    @Column(nullable = false)
    private String examCourseName;

    private String examTopic;

    private String examDateBogotaTimezone;

    /* Getters and setters */
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamCourseName() {
        return examCourseName;
    }

    public void setExamCourseName(String examCourseName) {
        this.examCourseName = examCourseName;
    }

    public String getExamTopic() {
        return examTopic;
    }

    public void setExamTopic(String examTopic) {
        this.examTopic = examTopic;
    }

    public String getExamDateBogotaTimezone() {
        return examDateBogotaTimezone;
    }

    public void setExamDateBogotaTimezone(String examDateBogotaTimezone) {
        this.examDateBogotaTimezone = examDateBogotaTimezone;
    }


}
