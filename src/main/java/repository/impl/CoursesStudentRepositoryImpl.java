package repository.impl;

import model.Course;
import model.dto.CourseDto;
import repository.CoursesStudentRepository;
import util.SecurityContext;

import static data.Database.*;
import static data.DatabaseQuery.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesStudentRepositoryImpl implements CoursesStudentRepository {
    @Override
    public boolean addCourse(int courseId, int studentId) throws SQLException {
        PreparedStatement pst = getPreparedStatement(ADD_COURSE_STUDENT);
        pst.setInt(1, courseId);
        pst.setInt(2, studentId);
        int i = pst.executeUpdate();
        pst = getPreparedStatement(FIND_EXAM_STUDENT);
        pst.setInt(1, courseId);
        ResultSet rs = pst.executeQuery();
        int j = 0;
        if (rs.next()) {
            pst = getPreparedStatement(ADD_EXAM_STUDENT);
            pst.setInt(1, studentId);
            pst.setInt(2, rs.getInt("exam_id"));
            j = pst.executeUpdate();
        } else {
            System.out.println("No exam found for the student.");
        }

        return i > 0 && j > 0;
    }

    @Override
    public boolean deleteCourse(int courseId, int studentId) throws SQLException {
        PreparedStatement pst = getPreparedStatement(DELETE_COURSE_STUDENT);
        pst.setInt(1, studentId);
        pst.setInt(2, courseId);
        int i = pst.executeUpdate();
        pst = getPreparedStatement(FIND_EXAM_STUDENT);
        pst.setInt(1, courseId);
        ResultSet rs = pst.executeQuery();
        int j = 0;
        if (rs.next()) {
            pst = getPreparedStatement(DELETE_EXAM_STUDENT);
            pst.setInt(1, rs.getInt("exam_id"));
            j = pst.executeUpdate();
        }
        return i > 0 && j > 0;
    }

    @Override
    public List<CourseDto> getCourses() throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_USER_COURSES);
        pst.setInt(1, SecurityContext.student.getId());
        ResultSet rs = pst.executeQuery();
        return getCourseDtos(rs);
    }

    @Override
    public List<CourseDto> getAllCourses() throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_ALL_USER_COURSES);
        ResultSet rs = pst.executeQuery();
        return getCourseDtos(rs);
    }

    static List<CourseDto> getCourseDtos(ResultSet rs) throws SQLException {
        List<CourseDto> courses = new ArrayList<>();
        while (rs.next()) {
            courses.add(new CourseDto(
                            rs.getString("course_title"),
                            rs.getInt("course_unit"),
                            rs.getString("teachername"),
                            rs.getDate("exam_date").toLocalDate(),
                            rs.getTime("exam_time").toLocalTime()
                    )
            );
        }
        return courses;
    }
}
