package repository;

import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CoursesStudentRepository {
    boolean save(int courseId, int studentId) throws SQLException;
    boolean remove(int courseId, int studentId) throws SQLException;
    Optional<List<CourseDto>> getAllUserCourses() throws SQLException;
    Optional<List<CourseDto>> getAll() throws SQLException;
}
