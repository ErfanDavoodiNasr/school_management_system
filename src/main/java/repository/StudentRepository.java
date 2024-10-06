package repository;

import model.Student;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {
    boolean addStudent(Student student) throws SQLException;
    boolean removeStudent(Student student) throws SQLException;
    boolean updateStudent(Student student) throws SQLException;
    List<Student> getAllStudents() throws SQLException;
    Student getStudentByNationalCode(String nationalCode) throws SQLException;
    Student getStudentByIdAndNationalCode(int id, String nationalCode) throws SQLException;

}
