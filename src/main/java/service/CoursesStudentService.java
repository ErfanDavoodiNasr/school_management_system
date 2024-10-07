package service;

import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CoursesStudentService {
    boolean addCourse(String courseTitle) throws SQLException;
    boolean removeCourse(String courseTitle) throws SQLException;
    List<CourseDto> getCourses() throws SQLException;
    List<CourseDto> getAllCourses() throws SQLException;
}
