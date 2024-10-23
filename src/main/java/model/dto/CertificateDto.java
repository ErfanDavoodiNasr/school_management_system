package model.dto;

import java.util.Objects;

public class CertificateDto {
    private String courseTitle;
    private Double score;

    public CertificateDto(String courseTitle, Double score) {
        this.courseTitle = courseTitle;
        this.score = score;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateDto that = (CertificateDto) o;
        return Objects.equals(courseTitle, that.courseTitle) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseTitle, score);
    }
}
