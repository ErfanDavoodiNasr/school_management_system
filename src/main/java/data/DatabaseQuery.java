package data;

public class DatabaseQuery {
    //student
    public static final String GET_ALL_STUDENTS = "SELECT * FROM students order by last_name,first_name,student_id";
    public static final String ADD_NEW_STUDENT = "INSERT INTO students (first_name, last_name, national_code) VALUES (?, ?, ?)";
    public static final String DELETE_STUDENT = "DELETE FROM students WHERE student_id = ?";
    public static final String GET_STUDENT_BY_NATIONAL_CODE = "SELECT * FROM students WHERE national_code = ?";
    public static final String UPDATE_STUDENT = "UPDATE students SET first_name = ?, last_name = ? WHERE national_code = ?";
    // teacher
    public static final String ADD_NEW_TEACHER = "INSERT INTO teachers (first_name, last_name, national_code) VALUES (?, ?, ?)";
    public static final String DELETE_TEACHER = "DELETE FROM teachers WHERE teacher_id = ?";
    public static final String GET_TEACHER_BY_NATIONAL_CODE = "SELECT * FROM teachers WHERE national_code = ?";
    public static final String GET_ALL_TEACHERS = "SELECT * FROM teachers order by last_name,first_name,teacher_id";
    public static final String UPDATE_TEACHER = "UPDATE teachers SET first_name = ?, last_name = ? WHERE national_code = ?";
    // course
    public static final String GET_ALL_COURSES = "SELECT * FROM courses";
    public static final String ADD_NEW_COURSE = "INSERT INTO courses (course_title, course_unit) VALUES (?, ?)";
    public static final String DELETE_COURSE = "DELETE FROM courses WHERE course_id = ?";
    public static final String GET_COURSE_BY_COURSE_TITLE = "SELECT * FROM courses WHERE course_title = ?";
    public static final String UPDATE_COURSE = "UPDATE courses SET course_title = ?, course_unit = ? WHERE course_id = ?";
    // exam
    public static final String GET_ALL_EXAMS = "SELECT * FROM exams";
    public static final String ADD_NEW_EXAM = "INSERT INTO exams (course_id, exam_title, exam_date, exam_time) VALUES (?, ?, ?, ?)";

}
