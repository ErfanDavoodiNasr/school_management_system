package service;

import model.dto.CertificateDto;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CoursesStudentService {
    boolean save(String courseTitle,int studentId) throws SQLException;
    boolean remove(String courseTitle) throws SQLException;
    Optional<List<CourseDto>> getAllUserCourses() throws SQLException;
    Optional<List<CourseDto>> getAll() throws SQLException;
    Optional<List<CertificateDto>> certificate() throws SQLException;
}
