package com.example.fonyou_test_code;

import com.example.fonyou_test_code.models.ExamModel;
import com.example.fonyou_test_code.models.StudentModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FonyouTestCodeApplicationTests {

    /* StudentModel tests */

    @Test
    void TestStudentCreation() {
        StudentModel student = new StudentModel();

        student.setStudentName("John Doe");
        student.setStudentAge(25);
        student.setStudentCity("Madrid");
        student.setStudentTimezone("Europe/Madrid");

        assert (student.getStudentName().equals("John Doe"));
        assert (student.getStudentAge() == 25);
        assert (student.getStudentCity().equals("Madrid"));
        assert (student.getStudentTimezone().equals("Europe/Madrid"));
    }

    @Test
    void TestStudentCreationWithNoAge() {
        StudentModel student = new StudentModel();

        student.setStudentName("John Doe");
        student.setStudentCity("Madrid");
        student.setStudentTimezone("Europe/Madrid");

        assert (student.getStudentName().equals("John Doe"));
        assert (student.getStudentAge() == null);
        assert (student.getStudentCity().equals("Madrid"));
        assert (student.getStudentTimezone().equals("Europe/Madrid"));
    }

    @Test
    void TestStudentCreationWithNoTimeZone() {
        // Should throw a NullPointerException because it's not possible to create a student without a timezone
        assertThrows(NullPointerException.class, () -> {
            StudentModel student = new StudentModel();

            student.setStudentName("John Doe");
            student.setStudentAge(25);
            student.setStudentCity("Madrid");

            assert (student.getStudentName().equals("John Doe"));
            assert (student.getStudentAge() == 25);
            assert (student.getStudentCity().equals("Madrid"));
            assert (student.getStudentTimezone().equals("Europe/Madrid"));
        });
    }

    @Test
    void TestStudentCreationWithNoTimeZoneAndNoCity() {
        assertThrows(NullPointerException.class, () -> {
            StudentModel student = new StudentModel();

            student.setStudentName("John Doe");
            student.setStudentAge(25);

            assert (student.getStudentName().equals("John Doe"));
            assert (student.getStudentAge() == 25);
            assert (student.getStudentCity().equals("Madrid"));
            assert (student.getStudentTimezone().equals("Europe/Madrid"));
        });
    }

    /* ExamModel tests */
    @Test
    void TestExamCreation() {
        ExamModel exam = new ExamModel();

        exam.setExamName("Test Exam");
        exam.setExamTopic("Test Topic");
        exam.setExamDate(ZonedDateTime.parse("2021-01-01T00:00:00-05:00"));

        assert (exam.getExamName().equals("Test Exam"));
        assert (exam.getExamTopic().equals("Test Topic"));
        assert (exam.getExamDate().equals(ZonedDateTime.parse("2021-01-01T00:00:00-05:00")));
    }

    @Test
    void TestExamCreationWithNoTopic() {
        ExamModel exam = new ExamModel();

        exam.setExamName("Test Exam");
        exam.setExamDate(ZonedDateTime.parse("2021-10-10T10:00:00-05:00"));

        assert (exam.getExamName().equals("Test Exam"));
        assert (exam.getExamTopic() == null);
        assert (exam.getExamDate().equals(ZonedDateTime.parse("2021-10-10T10:00:00-05:00")));
    }

    @Test
    void TestExamCreationWithNoName() {
        assertThrows(NullPointerException.class, () -> {
            ExamModel exam = new ExamModel();

            exam.setExamTopic("Test Topic");
            exam.setExamDate(ZonedDateTime.parse("2021-10-10T10:00:00-05:00"));

            assert (exam.getExamName().equals("Test Exam"));
            assert (exam.getExamTopic().equals("Test Topic"));
            assert (exam.getExamDate().equals(ZonedDateTime.parse("2021-10-10T10:00:00-05:00")));
        });
    }

    @Test
    void TestExamCreationWithNoTimezone() {
        assertThrows(NullPointerException.class, () -> {
            ExamModel exam = new ExamModel();

            exam.setExamName("Test Exam");
            exam.setExamTopic("Test Topic");

            assert (exam.getExamName().equals("Test Exam"));
            assert (exam.getExamTopic().equals("Test Topic"));
            assert (exam.getExamDate().equals("2021-01-01T00:00:00-05:00"));
        });
    }

}
