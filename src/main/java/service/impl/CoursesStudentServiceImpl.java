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
    public boolean save(String courseTitle) throws SQLException {
        Course course = cr.getByTitle(courseTitle);
        if (course == null) {
            throw new SQLException("Course not found");
        }
        return csr.save(course.getCourseId(), SecurityContext.student.getId());
    }

    @Override
    public boolean remove(String courseTitle) throws SQLException {
        Course course = cr.getByTitle(courseTitle);
        if (course == null) {
            throw new SQLException("Course not found");
        }
        return csr.remove(course.getCourseId(), SecurityContext.student.getId());
    }

    @Override
    public List<CourseDto> getAllUserCourses() throws SQLException {
        if (csr.getAllUserCourses() == null){
            return null;
        }
        return csr.getAllUserCourses();
    }

    @Override
    public List<CourseDto> getAll() throws SQLException {
        if (csr.getAll() == null){
            return null;
        }
        return csr.getAll();
    }
}
