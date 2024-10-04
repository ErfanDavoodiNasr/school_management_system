package repository.impl;

import model.Student;
import repository.StudentRepository;

import static data.Database.*;
import static data.DatabaseQuery.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public boolean addStudent(Student student) throws SQLException {
        PreparedStatement pst = getPreparedStatement(ADD_NEW_STUDENT);
        pst.setString(1, student.getFirst_name());
        pst.setString(2, student.getLast_name());
        pst.setString(3, student.getNationalCode());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean removeStudent(Student student) throws SQLException {
        PreparedStatement pst = getPreparedStatement(DELETE_STUDENT);
        pst.setInt(1, student.getId());
        int affectedRows = pst.executeUpdate();
        return affectedRows > 0;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        PreparedStatement pst = getPreparedStatement(UPDATE_STUDENT);
        pst.setString(1, student.getFirst_name());
        pst.setString(2, student.getLast_name());
        pst.setString(3, student.getNationalCode());
        return pst.executeUpdate() > 0;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        ResultSet rs = getResultSet(GET_ALL_STUDENTS);
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            students.add(new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("national_code")
            ));
        }
        return students;
    }

    @Override
    public Student getStudentByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_STUDENT_BY_NATIONAL_CODE);
        pst.setString(1, nationalCode);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("national_code")
            );
        }
        return null;
    }
}
