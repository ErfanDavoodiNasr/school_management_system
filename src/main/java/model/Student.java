package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Student extends Person {
    private LocalDate entryDate;
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

    public Student(String first_name, String last_name, LocalDate birthDate, String nationalCode, String phoneNumber, LocalDate entryDate) {
        super(first_name, last_name, birthDate, nationalCode, phoneNumber);
        this.entryDate = entryDate;
    }

    public Student(int id, String first_name, String last_name, LocalDate birthDate, String nationalCode, String phoneNumber, LocalDate entryDate, double averageScore) {
        super(id, first_name, last_name, birthDate, nationalCode, phoneNumber);
        this.entryDate = entryDate;
        this.averageScore = averageScore;
    }

    public Student(int studentId, String firstName, String lastName, LocalDate birthDate, String nationalCode, String phoneNumber, LocalDate entryDate) {
        super(studentId,firstName,lastName,birthDate,nationalCode,phoneNumber);
        this.entryDate = entryDate;
    }

    public Student(int studentId, String firstName, String lastName, String nationalCode, double avgScore) {
        super(studentId,firstName,lastName,nationalCode);
        this.averageScore = avgScore;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
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
