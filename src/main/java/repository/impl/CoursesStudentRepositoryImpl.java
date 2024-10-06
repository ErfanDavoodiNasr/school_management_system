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
        // Insert into courses_students
        PreparedStatement pst1 = getPreparedStatement(ADD_COURSE_STUDENT);
        pst1.setInt(1, courseId);
        pst1.setInt(2, studentId);
        pst1.executeUpdate();

        // Find exam_id for the student
        PreparedStatement pst2 = getPreparedStatement(FIND_EXAM_STUDENT);
        pst2.setInt(1, studentId);
        ResultSet rs = pst2.executeQuery();

        // Insert into exams_students
        if (rs.next()) {
            PreparedStatement pst3 = getPreparedStatement(ADD_EXAM_STUDENT);
            pst3.setInt(1, studentId);
            pst3.setInt(2, rs.getInt("exam_id"));
            pst3.executeUpdate();
        } else {
            System.out.println("No exam found for the student.");
        }

        return true;
    }

    @Override
    public boolean deleteCourse(int courseId, int studentId) {
        return false;
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
        ResultSet rs = getResultSet(GET_ALL_USER_COURSES);
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
