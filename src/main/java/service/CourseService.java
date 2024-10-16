package service;

import model.Course;

import java.sql.SQLException;
import java.util.Optional;

public interface CourseService {
    boolean save(Course course) throws SQLException;
    boolean update(String courseTitle, Course newCourse) throws SQLException;
    boolean remove(String courseTitle) throws SQLException;
    void printAll() throws SQLException;
    Optional<Course> getByTitle(String courseTitle) throws SQLException;
}
