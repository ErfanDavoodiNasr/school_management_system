package model;

import java.util.Date;
import java.util.Objects;

public class Student extends Person {
    private Date entryDate;
    private double averageScore;

    public Student() {
    }

    public Student(int id, String first_name, String last_name, String nationalCode) {
        super(id, first_name, last_name, nationalCode);
    }

    public Student(String first_name, String nationalCode) {
        super(first_name, nationalCode);
    }

    public Student(String first_name, String last_name, String nationalCode) {
        super(first_name, last_name, nationalCode);
    }

    public Student(String first_name, String last_name, String nationalCode, String phoneNumber) {
        super(first_name, last_name, nationalCode, phoneNumber);
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Double.compare(averageScore, student.averageScore) == 0 && Objects.equals(entryDate, student.entryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entryDate, averageScore);
    }
}
