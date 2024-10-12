package service;

import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CoursesStudentService {
    boolean save(String courseTitle) throws SQLException;
    boolean remove(String courseTitle) throws SQLException;
    List<CourseDto> getAllUserCourses() throws SQLException;
    List<CourseDto> getAll() throws SQLException;
}
