package repository;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {
    boolean save(Student student) throws SQLException;
    boolean remove(Student student) throws SQLException;
    boolean update(Student student) throws SQLException;
    List<Student> getAll() throws SQLException;
    Student getByNationalCode(String nationalCode) throws SQLException;
    Student getByIdAndNationalCode(int id, String nationalCode) throws SQLException;

}
