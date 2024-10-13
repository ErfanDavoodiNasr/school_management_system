package service;

import model.Teacher;

import java.sql.SQLException;
import java.util.Optional;

public interface TeacherService {
    boolean save(Teacher teacher) throws SQLException;
    boolean remove(String nationalCode) throws SQLException;
    boolean update(String nationalCode, Teacher newTeacher) throws SQLException;
    void printAll() throws SQLException;
    Optional<Teacher> getByNationalCode(String nationalCode) throws SQLException;
    void printAllStudents() throws SQLException;
    boolean signIn(int teacherId, String nationalCode) throws SQLException;
    boolean grading(String nationalCodeStudent, int courseId , double avgScore) throws SQLException;
}
