package model;

public class Teacher extends Person {
    private int courseId;

    public Teacher() {
    }

    public Teacher(String first_name, String nationalCode) {
        super(first_name, nationalCode);
    }

    public Teacher(int id, String first_name, String last_name, String nationalCode) {
        super(id, first_name, last_name, nationalCode);
    }

    public Teacher(String first_name, String last_name, String nationalCode) {
        super(first_name, last_name, nationalCode);
    }

    public Teacher(String first_name, String last_name, String nationalCode, String phoneNumber) {
        super(first_name, last_name, nationalCode, phoneNumber);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
