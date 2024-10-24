package data;

public class DatabaseQuery {
    //student
    public static final String GET_ALL_STUDENTS = "SELECT * FROM students order by last_name,first_name,student_id";
    public static final String ADD_NEW_STUDENT = "INSERT INTO students (first_name, last_name, birth_date, entry_date, phone_number, national_code) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_STUDENT_BY_ID_NATIONAL_CODE = "select * from students where student_id = ? and national_code = ?";
    public static final String DELETE_STUDENT = "DELETE FROM students WHERE student_id = ?";
    public static final String GET_STUDENT_BY_NATIONAL_CODE = "SELECT * FROM students WHERE national_code = ?";
    public static final String UPDATE_STUDENT = "UPDATE students SET first_name = ?, last_name = ? WHERE national_code = ?";
    public static final String ADD_COURSE_STUDENT = "insert into courses_students(course_id, student_id) values (?,?)";
    public static final String ADD_EXAM_STUDENT = "insert into exams_students (student_id, exam_id) values (?,?);";
    public static final String FIND_EXAM_STUDENT = "select e.exam_id from courses c join exams e on e.course_id = c.course_id where c.course_id = ?";
    public static final String DELETE_COURSE_STUDENT = "delete from courses_students cs where student_id = ? and course_id = ?";
    public static final String DELETE_EXAM_STUDENT = "delete from exams_students where exam_id = ?";
    public static final String DELETE_STUDENT_ID_EXAM = "DELETE FROM exams_students WHERE student_id = ?";
    public static final String DELETE_STUDENT_ID_COURSES = "DELETE FROM courses_students WHERE student_id = ?";
    public static final String GRADING_TO_STUDENT = "UPDATE courses_students SET avg_score = ? WHERE student_id = ? and course_id = ?";
    public static final String STUDENT_CERTIFICATE = """
            select c.course_title, cs.avg_score
            from courses_students cs
                     join courses c on c.course_id = cs.course_id
            where cs.student_id = ?;
            """;
    // teacher
    public static final String ADD_NEW_TEACHER = "INSERT INTO teachers (first_name, last_name, national_code, course_id) VALUES (?, ?, ?, ?)";
    public static final String DELETE_TEACHER = "DELETE FROM teachers WHERE teacher_id = ?";
    public static final String GET_TEACHER_BY_NATIONAL_CODE = "SELECT * FROM teachers WHERE national_code = ?";
    public static final String ADD_COURSE_TO_TEACHER = "update teachers set course_id = ? where teacher_id = ?;";
    public static final String GET_ALL_TEACHERS = "SELECT * FROM teachers order by last_name,first_name,teacher_id";
    public static final String UPDATE_TEACHER = "UPDATE teachers SET first_name = ?, last_name = ? WHERE national_code = ?";
    public static final String GET_TEACHER_BY_ID_NATIONAL_CODE = "select * from teachers where teacher_id = ? and national_code = ?";
    public static final String SHOW_TEACHER_STUDENTS = "select s.student_id, concat(s.first_name , ' ' , s.last_name) as full_name, s.national_code, cs.avg_score as score, s.avg_score as avg_score from teachers t join courses_students cs on t.course_id = cs.course_id join students s on cs.student_id = s.student_id where t.teacher_id = ?";
    public static final String AVG_SCORE_STUDENT = "Update students\n" +
            "SET avg_score = (select avg(avg_score) from courses_students where courses_students.student_id = ?)\n" +
            "where student_id = ?";
    // course
    public static final String GET_ALL_COURSES = "SELECT * FROM courses";
    public static final String ADD_NEW_COURSE = "INSERT INTO courses (course_title, course_unit) VALUES (?, ?)";
    public static final String DELETE_COURSE = "DELETE FROM courses WHERE course_id = ?";
    public static final String GET_COURSE_BY_COURSE_TITLE = "SELECT * FROM courses WHERE course_title = ?";
    public static final String UPDATE_COURSE = "UPDATE courses SET course_title = ?, course_unit = ? WHERE course_id = ?";
    public static final String GET_USER_COURSES = "select c.course_title, c.course_unit, concat(t.first_name, ' ', t.last_name) as teacherName, e.exam_date, e.exam_time, cs.avg_score from courses c join courses_students cs on c.course_id = cs.course_id join teachers t on c.course_id = t.course_id join public.exams e on c.course_id = e.course_id where student_id = ?";
    public static final String GET_ALL_USERS_COURSES = "select c.course_title, c.course_unit, concat(t.first_name, ' ', t.last_name) as teacherName, e.exam_date, e.exam_time from courses c join teachers t on c.course_id = t.course_id join public.exams e on c.course_id = e.course_id";
    // exam
    public static final String ADD_NEW_EXAM = "INSERT INTO exams (course_id, exam_title, exam_date, exam_time) VALUES (?, ?, ?, ?)";
    public static final String DELETE_EXAM = "DELETE FROM exams WHERE course_id = ?";
    // admin
    public static final String SIGN_IN_ADMIN = "select * from admin where id = ? and national_code = ?";
}
