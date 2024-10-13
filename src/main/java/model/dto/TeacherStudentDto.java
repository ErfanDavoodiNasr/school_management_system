package model.dto;

import java.util.Objects;

public class TeacherStudentDto {
    private int studentId;
    private String fullName;
    private String nationalCode;
    private double avgScore;
    private double score;

    public TeacherStudentDto(int studentId, String fullName, String nationalCode, double avgScore, double score) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.avgScore = avgScore;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherStudentDto that = (TeacherStudentDto) o;
        return studentId == that.studentId && Double.compare(avgScore, that.avgScore) == 0 && Objects.equals(fullName, that.fullName) && Objects.equals(nationalCode, that.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, fullName, nationalCode, avgScore);
    }

    @Override
    public String toString() {
        return "TeacherStudentDto{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }
}
