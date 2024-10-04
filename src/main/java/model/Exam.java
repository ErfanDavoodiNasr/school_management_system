package model;

import java.sql.Date;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Exam {
    private int examId;
    private int courseId;
    private String examTitle;
    private LocalDate examDate;
    private LocalTime examTime;

    public Exam(int courseId, String examTitle, LocalDate examDate, LocalTime examTime) {
        this.courseId = courseId;
        this.examTitle = examTitle;
        this.examDate = examDate;
        this.examTime = examTime;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalTime getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalTime examTime) {
        this.examTime = examTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return examId == exam.examId && courseId == exam.courseId && Objects.equals(examTitle, exam.examTitle) && Objects.equals(examDate, exam.examDate) && Objects.equals(examTime, exam.examTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, courseId, examTitle, examDate, examTime);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", courseId=" + courseId +
                ", examTitle='" + examTitle + '\'' +
                ", examDate=" + examDate +
                ", examTime=" + examTime +
                '}';
    }
}
