package repository.impl;

import model.Course;
import repository.CourseRepository;
import static data.Database.*;
import static data.DatabaseQuery.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public boolean save(Course course) throws SQLException {
        PreparedStatement pst = getPreparedStatement(ADD_NEW_COURSE);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean update(Course course) throws SQLException {
        PreparedStatement pst = getPreparedStatement(UPDATE_COURSE);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        pst.setInt(3, course.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean remove(Course course) throws SQLException {
        PreparedStatement pst = getPreparedStatement(DELETE_EXAM);
        pst.setInt(1, course.getCourseId());
        int i = pst.executeUpdate();
        pst = getPreparedStatement(DELETE_COURSE);
        pst.setInt(1, course.getCourseId());
        int j = pst.executeUpdate();
        return  i > 0 && j > 0;
    }

    @Override
    public Optional<List<Course>> getAll() throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_ALL_COURSES);
        ResultSet rs = pst.executeQuery();
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            courses.add(new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_title"),
                    rs.getInt("course_unit")));
        }
        return Optional.of(courses);
    }

    @Override
    public Optional<Course> getByTitle(String courseTitle) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_COURSE_BY_COURSE_TITLE);
        pst.setString(1, courseTitle);
        ResultSet rs = pst.executeQuery();
        Optional<Course> optionalCourse = Optional.empty();
        if (rs.next()) {
            Course course =  new Course(rs.getInt("course_id"),
                    rs.getString("course_title"),
                    rs.getInt("course_unit"));
            optionalCourse = Optional.of(course);
        }
        return optionalCourse;
    }
}
