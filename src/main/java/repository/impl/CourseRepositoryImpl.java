package repository.impl;

import model.Course;
import repository.CourseRepository;
import static data.Database.*;
import static data.DatabaseQuery.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public boolean addCourse(Course course) throws SQLException {
        PreparedStatement pst = getPreparedStatement(ADD_NEW_COURSE);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean updateCourse(Course course) throws SQLException {
        PreparedStatement pst = getPreparedStatement(UPDATE_COURSE);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        pst.setInt(3, course.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean deleteCourse(Course course) throws SQLException {
        PreparedStatement pst = getPreparedStatement(DELETE_COURSE);
        pst.setInt(1, course.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        ResultSet rs = getResultSet(GET_ALL_COURSES);
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            courses.add(new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_title"),
                    rs.getInt("course_unit")));
        }
        return courses;
    }

    @Override
    public Course getCourse(String courseTitle) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_COURSE_BY_COURSE_TITLE);
        pst.setString(1, courseTitle);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new Course(rs.getInt("course_id"),
                    rs.getString("course_title"),
                    rs.getInt("course_unit"));
        }
        return null;
    }
}
