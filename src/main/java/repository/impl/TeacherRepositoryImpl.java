package repository.impl;

import model.Teacher;
import repository.TeacherRepository;

import static data.Database.getPreparedStatement;
import static data.DatabaseQuery.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Teacher> getAll() throws SQLException {
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
        return teachers;
    }

    @Override
    public Teacher getByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_TEACHER_BY_NATIONAL_CODE);
        pst.setString(1, nationalCode);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new Teacher(
                    rs.getInt("teacher_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("national_code")
            );
        }
        return null;
    }
}
