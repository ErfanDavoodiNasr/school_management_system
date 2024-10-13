package service.impl;

import model.Course;
import model.dto.CourseDto;
import repository.CourseRepository;
import repository.CoursesStudentRepository;
import service.CoursesStudentService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CoursesStudentServiceImpl implements CoursesStudentService {
    private final CoursesStudentRepository csr;
    private final CourseRepository cr;

    public CoursesStudentServiceImpl(CoursesStudentRepository csr, CourseRepository cr) {
        this.csr = csr;
        this.cr = cr;
    }

    @Override
    public boolean save(String courseTitle) throws SQLException {
        Optional<Course> course = cr.getByTitle(courseTitle);
        if (course.isEmpty()) {
            throw new SQLException("Course not found");
        }
        return csr.save(course.get().getCourseId(), SecurityContext.student.getId());
    }

    @Override
    public boolean remove(String courseTitle) throws SQLException {
        Optional<Course> course = cr.getByTitle(courseTitle);
        if (course.isEmpty()) {
            throw new SQLException("Course not found");
        }
        return csr.remove(course.get().getCourseId(), SecurityContext.student.getId());
    }

    @Override
    public Optional<List<CourseDto>> getAllUserCourses() throws SQLException {
        if (csr.getAllUserCourses().isEmpty()){
            throw new SQLException("Course not found");
        }
        return csr.getAllUserCourses();
    }

    @Override
    public Optional<List<CourseDto>> getAll() throws SQLException {
        Optional<List<CourseDto>> optionalCourseDtos = csr.getAll();
        if (optionalCourseDtos.isEmpty()){
            throw new SQLException("Course not found");
        }
        return optionalCourseDtos;
    }
}
