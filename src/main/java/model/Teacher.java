package model;

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


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
