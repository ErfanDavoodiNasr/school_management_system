package repository.impl;

import model.dto.CertificateDto;
import model.dto.CourseDto;
import repository.CoursesStudentRepository;
import util.SecurityContext;

import static data.Database.*;
import static data.DatabaseQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoursesStudentRepositoryImpl implements CoursesStudentRepository {
    @Override
    public boolean save(int courseId, int studentId) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(ADD_COURSE_STUDENT);
            pst.setInt(1, courseId);
            pst.setInt(2, studentId);
            int i = pst.executeUpdate();
            pst = conn.prepareStatement(FIND_EXAM_STUDENT);
            pst.setInt(1, courseId);
            ResultSet rs = pst.executeQuery();
            int j = 0;
            if (rs.next()) {
                pst = conn.prepareStatement(ADD_EXAM_STUDENT);
                pst.setInt(1, studentId);
                pst.setInt(2, rs.getInt("exam_id"));
                j = pst.executeUpdate();
            } else {
                System.out.println("No exam found for the student.");
            }

            return i > 0 && j > 0;
        }
    }

    @Override
    public boolean remove(int courseId, int studentId) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(DELETE_COURSE_STUDENT);
            pst.setInt(1, studentId);
            pst.setInt(2, courseId);
            int i = pst.executeUpdate();
            pst = conn.prepareStatement(FIND_EXAM_STUDENT);
            pst.setInt(1, courseId);
            ResultSet rs = pst.executeQuery();
            int j = 0;
            if (rs.next()) {
                pst = conn.prepareStatement(DELETE_EXAM_STUDENT);
                pst.setInt(1, rs.getInt("exam_id"));
                j = pst.executeUpdate();
            }
            return i > 0 && j > 0;
        }
    }

    @Override
    public Optional<List<CourseDto>> getAllUserCourses() throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(GET_USER_COURSES);
            pst.setInt(1, SecurityContext.student.getId());
            ResultSet rs = pst.executeQuery();
            List<CourseDto> courses = new ArrayList<>();
            while (rs.next()) {
                courses.add(new CourseDto(
                                rs.getString("course_title"),
                                rs.getInt("course_unit"),
                                rs.getString("teachername"),
                                rs.getDate("exam_date").toLocalDate(),
                                rs.getTime("exam_time").toLocalTime(),
                                rs.getDouble("avg_score")
                        )
                );
            }
            return Optional.of(courses);
        }
    }

    @Override
    public Optional<List<CourseDto>> getAll() throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(GET_ALL_USERS_COURSES);
            ResultSet rs = pst.executeQuery();
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
            if (courses.isEmpty()) {
                return Optional.empty();
            } else {
                return Optional.of(courses);
            }
        }
    }

    @Override
    public Optional<List<CertificateDto>> certificate(int studentId) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(STUDENT_CERTIFICATE);
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            List<CertificateDto> certificateDtoList = new ArrayList<>();

            while (rs.next()) {
                certificateDtoList.add(
                        new CertificateDto(rs.getString("course_title"),
                                rs.getDouble("avg_score")));
            }
            if (certificateDtoList.isEmpty()) {
                throw new RuntimeException("there is some problem");
            } else {
                return Optional.of(certificateDtoList);
            }
        }
    }
}
