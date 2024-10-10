package service;

import model.Student;
import model.Teacher;

import java.sql.SQLException;

public interface TeacherService {
    boolean addTeacher(Teacher teacher) throws SQLException;
    boolean removeTeacher(String nationalCode) throws SQLException;
    boolean updateTeacher(String nationalCode, Teacher newTeacher) throws SQLException;
    void printAllTeachers() throws SQLException;
    Teacher generateTeacher(String firstName, String lastName, String nationalCode, int courseId) throws SQLException;
    Teacher getTeacherByNationalCode(String nationalCode) throws SQLException;
}
