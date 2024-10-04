package repository;

import model.Student;
import model.Teacher;
import java.sql.SQLException;
import java.util.List;

public interface TeacherRepository {
    boolean addTeacher(Teacher teacher) throws SQLException;
    boolean removeTeacher(Teacher teacher) throws SQLException;
    boolean updateTeacher(Teacher teacher) throws SQLException;
    List<Teacher> getAllTeachers() throws SQLException;
    Teacher getTeacherNationalCode(String nationalCode) throws SQLException;
}
