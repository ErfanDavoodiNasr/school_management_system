package service;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseService {
    Course addCourse(Course course) throws SQLException;
    boolean updateCourse(String courseTitle,Course newCourse) throws SQLException;
    boolean deleteCourse(String courseTitle) throws SQLException;
    Course generateCourse(String courseTitle,int courseUnit) throws SQLException;
    void printAllCourses() throws SQLException;
    Course getCoursesByTitle(String courseTitle) throws SQLException;
}
