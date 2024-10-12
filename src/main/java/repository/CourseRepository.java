package repository;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseRepository {
    Course save(Course course) throws SQLException;
    boolean update(Course course) throws SQLException;
    boolean remove(Course course) throws SQLException;
    List<Course> getAll() throws SQLException;
    Course getByTitle(String courseTitle) throws SQLException;
}
