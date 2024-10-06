package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

public class ApplicationContext {
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final TeacherRepository teacherRepository;
    private static final TeacherService teacherService;
    private static final CourseService courseService;
    private static final CourseRepository courseRepository;
    private static final ExamRepository examRepository;
    private static final ExamService examService;
    private static final CoursesStudentRepository coursesStudentRepository;
    private static final CoursesStudentService coursesStudentService;

    static {
        studentRepository = new StudentRepositoryImpl();
        studentService = new StudentServiceImpl(studentRepository);
        teacherRepository = new TeacherRepositoryImpl();
        teacherService = new TeacherServiceImpl(teacherRepository);
        courseRepository = new CourseRepositoryImpl();
        courseService = new CourseServiceImpl(courseRepository);
        examRepository = new ExamRepositoryImpl();
        examService = new ExamServiceImpl(examRepository);
        coursesStudentRepository = new CoursesStudentRepositoryImpl();
        coursesStudentService = new CoursesStudentServiceImpl(coursesStudentRepository,courseRepository);
    }

    public static StudentService getStudentService() {
        return studentService;
    }

    public static TeacherService getTeacherService() {
        return teacherService;
    }

    public static CourseService getCourseService() {
        return courseService;
    }
    public static ExamService getExamService() {
        return examService;
    }
    public static CoursesStudentService getCoursesStudentService() {
        return coursesStudentService;
    }
}
