package model;

import java.time.LocalDate;

public class Teacher extends Person {
    private int courseId;

    public Teacher() {
    }

    public Teacher(String first_name, String last_name, String nationalCode, int courseId) {
        super(first_name, last_name, nationalCode);
        this.courseId = courseId;
    }

    public Teacher(int id, String first_name, String last_name, String nationalCode) {
        super(id, first_name, last_name, nationalCode);
    }

    public Teacher(int teacherId, String firstName, String lastName, LocalDate birthDate, String nationalCode, String phoneNumber, LocalDate entryDate) {
        this(teacherId, firstName, lastName, nationalCode);
        this.setBirthDate(birthDate);
        this.setPhoneNumber(phoneNumber);
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
