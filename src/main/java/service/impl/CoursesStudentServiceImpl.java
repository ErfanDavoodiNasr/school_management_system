package service.impl;

import model.Course;
import model.dto.CourseDto;
import repository.CourseRepository;
import repository.CoursesStudentRepository;
import service.CoursesStudentService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;

public class CoursesStudentServiceImpl implements CoursesStudentService {
    private final CoursesStudentRepository csr;
    private final CourseRepository cr;

    public CoursesStudentServiceImpl(CoursesStudentRepository csr, CourseRepository cr) {
        this.csr = csr;
        this.cr = cr;
    }

    @Override
    public boolean addCourse(String courseTitle) throws SQLException {
        Course course = cr.getCourse(courseTitle);
        if (course == null) {
            throw new SQLException("Course not found");
        }
        return csr.addCourse(course.getCourseId(), SecurityContext.student.getId());
    }

    @Override
    public List<CourseDto> getCourses() throws SQLException {
        if (csr.getCourses() == null){
            return null;
        }
        return csr.getCourses();
    }

    @Override
    public List<CourseDto> getAllCourses() throws SQLException {
        if (csr.getAllCourses() == null){
            return null;
        }
        return csr.getAllCourses();
    }
}
