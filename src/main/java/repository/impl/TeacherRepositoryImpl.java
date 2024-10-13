package repository.impl;

import model.Teacher;
import model.dto.TeacherStudentDto;
import repository.TeacherRepository;
import util.SecurityContext;

import static data.Database.getPreparedStatement;
import static data.DatabaseQuery.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {

    @Override
    public boolean save(Teacher teacher) throws SQLException {
        PreparedStatement pst = getPreparedStatement(ADD_NEW_TEACHER);
        pst.setString(1, teacher.getFirst_name());
        pst.setString(2, teacher.getLast_name());
        pst.setString(3, teacher.getNationalCode());
        pst.setInt(4,teacher.getCourseId());
        pst.executeUpdate();
        return true;
    }

    @Override
    public boolean remove(Teacher teacher) throws SQLException {
        PreparedStatement pst = getPreparedStatement(DELETE_TEACHER);
        pst.setInt(1, teacher.getId());
        pst.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Teacher teacher) throws SQLException {
        PreparedStatement pst = getPreparedStatement(UPDATE_TEACHER);
        pst.setString(1, teacher.getFirst_name());
        pst.setString(2, teacher.getLast_name());
        pst.setInt(3, teacher.getCourseId());
        pst.setString(4, teacher.getNationalCode());
        return pst.executeUpdate() > 0;
    }

    @Override
    public Optional<List<Teacher>> getAll() throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_ALL_TEACHERS);
        ResultSet rs = pst.executeQuery();
        List<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            teachers.add(new Teacher(
                    rs.getInt("teacher_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("national_code")
            ));
        }
        return Optional.of(teachers);
    }

    @Override
    public Optional<Teacher> getByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_TEACHER_BY_NATIONAL_CODE);
        pst.setString(1, nationalCode);
        ResultSet rs = pst.executeQuery();
        Optional<Teacher> optionalTeacher = Optional.empty();
        if (rs.next()) {
            Teacher teacher = new Teacher(
                    rs.getInt("teacher_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("national_code")
            );
            optionalTeacher = Optional.of(teacher);
        }
        return optionalTeacher;
    }

    @Override
    public Optional<List<TeacherStudentDto>> getAllStudents() throws SQLException {
        PreparedStatement pst = getPreparedStatement(SHOW_TEACHER_STUDENTS);
        pst.setInt(1, SecurityContext.teacher.getId());
        ResultSet rs = pst.executeQuery();
        List<TeacherStudentDto> students = new ArrayList<>();
        while (rs.next()) {
            students.add(new TeacherStudentDto(
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getString("national_code"),
                    rs.getDouble("avg_score"),
                    rs.getDouble("score")
            ));
        }
        return Optional.of(students);
    }

    @Override
    public Optional<Teacher> getByIdAndNationalCode(int id, String nationalCode) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_TEACHER_BY_ID_NATIONAL_CODE);
        pst.setInt(1, id);
        pst.setString(2, nationalCode);
        ResultSet rs = pst.executeQuery();
        Optional<Teacher> optionalTeacher = Optional.empty();
        if (rs.next()) {
            Teacher teacher = new Teacher(
                    rs.getInt("teacher_id"),
                    rs.getInt("course_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("birth_date").toLocalDate(),
                    rs.getString("national_code"),
                    rs.getString("phone_number"),
                    rs.getDate("entry_date").toLocalDate()
            );
            optionalTeacher = Optional.of(teacher);
        }
        return optionalTeacher;
    }

    @Override
    public boolean grading(int studentId, int courseId , double avgScore) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GRADING_TO_STUDENT);
        pst.setDouble(1, avgScore);
        pst.setInt(2, studentId);
        pst.setInt(3, courseId);
        int i = pst.executeUpdate();
        pst = getPreparedStatement(AVG_SCORE_STUDENT);
        pst.setInt(1, studentId);
        pst.setInt(2, studentId);
        int j = pst.executeUpdate();
        return i >0 && j > 0;
    }
}
