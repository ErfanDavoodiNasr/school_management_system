package service;

import model.Student;

import java.sql.SQLException;

public interface StudentService {
    boolean addStudent(Student student) throws SQLException;
    boolean removeStudent(String nationalCode) throws SQLException;
    boolean updateStudent(String nationalCode, Student newStudent) throws SQLException;
    void printAllStudents() throws SQLException;
    Student generateStudent(String firstName, String lastName, String nationalCode) throws SQLException;
    Student getStudentByNationalCode(String nationalCode) throws SQLException;
}
