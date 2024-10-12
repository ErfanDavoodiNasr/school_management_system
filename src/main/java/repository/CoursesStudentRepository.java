package repository;

import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CoursesStudentRepository {
    boolean save(int courseId, int studentId) throws SQLException;
    boolean remove(int courseId, int studentId) throws SQLException;
    List<CourseDto> getAllUserCourses() throws SQLException;
    List<CourseDto> getAll() throws SQLException;
}
