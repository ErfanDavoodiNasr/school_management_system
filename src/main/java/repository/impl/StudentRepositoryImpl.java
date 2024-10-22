package repository.impl;

import model.Student;
import repository.StudentRepository;

import static data.Database.*;
import static data.DatabaseQuery.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public boolean save(Student student) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(ADD_NEW_STUDENT);
            pst.setString(1, student.getFirst_name());
            pst.setString(2, student.getLast_name());
            pst.setDate(3, Date.valueOf(student.getBirthDate()));
            pst.setDate(4, Date.valueOf(student.getEntryDate()));
            pst.setString(5, student.getPhoneNumber());
            pst.setString(6, student.getNationalCode());
            return pst.executeUpdate() > 0;
        }
    }

    @Override
    public boolean remove(Student student) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(DELETE_STUDENT_ID_COURSES);
            pst.setInt(1, student.getId());
            int i = pst.executeUpdate();
            pst = conn.prepareStatement(DELETE_STUDENT_ID_EXAM);
            pst.setInt(1, student.getId());
            int j = pst.executeUpdate();
            pst = conn.prepareStatement(DELETE_STUDENT);
            pst.setInt(1, student.getId());
            int k = pst.executeUpdate();
            return i > 0 && j > 0 && k > 0;
        }
    }

    @Override
    public boolean update(Student student) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(UPDATE_STUDENT);
            pst.setString(1, student.getFirst_name());
            pst.setString(2, student.getLast_name());
            pst.setString(3, student.getNationalCode());
            return pst.executeUpdate() > 0;
        }
    }

    @Override
    public Optional<List<Student>> getAll() throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(GET_ALL_STUDENTS);
            ResultSet rs = pst.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("national_code"),
                        rs.getDouble("avg_score")
                ));
            }
            return Optional.of(students);
        }
    }

    @Override
    public Optional<Student> getByNationalCode(String nationalCode) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(GET_STUDENT_BY_NATIONAL_CODE);
            pst.setString(1, nationalCode);
            ResultSet rs = pst.executeQuery();
            Optional<Student> optionalStudent = Optional.empty();
            if (rs.next()) {
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("national_code")
                );
                optionalStudent = Optional.of(student);
            }
            return optionalStudent;
        }
    }

    @Override
    public Optional<Student> getByIdAndNationalCode(int id, String nationalCode) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(GET_STUDENT_BY_ID_NATIONAL_CODE);
            pst.setInt(1, id);
            pst.setString(2, nationalCode);
            ResultSet rs = pst.executeQuery();
            Optional<Student> optionalStudent = Optional.empty();
            if (rs.next()) {
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("national_code"),
                        rs.getString("phone_number"),
                        rs.getDate("entry_date").toLocalDate()
                );
                optionalStudent = Optional.of(student);
            }
            return optionalStudent;
        }
    }
}
