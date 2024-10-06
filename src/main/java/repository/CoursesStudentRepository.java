package repository;

import model.Course;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CoursesStudentRepository {
    boolean addCourse(int courseId, int studentId) throws SQLException;
    boolean deleteCourse(int courseId, int studentId);
    List<CourseDto> getCourses() throws SQLException;
    List<CourseDto> getAllCourses() throws SQLException;
}
