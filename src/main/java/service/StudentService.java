package service;

import model.Student;

import java.sql.SQLException;
import java.util.Optional;

public interface StudentService {
    boolean save(Student student) throws SQLException;
    boolean remove(String nationalCode) throws SQLException;
    boolean update(String nationalCode, Student newStudent) throws SQLException;
    void printAll() throws SQLException;
    Optional<Student> getByNationalCode(String nationalCode) throws SQLException;
    boolean signIn(int studentId, String nationalCode) throws SQLException;
}
