package repository.impl;

import model.Exam;
import repository.ExamRepository;

import static data.Database.*;
import static data.DatabaseQuery.*;

import java.sql.*;

public class ExamRepositoryImpl implements ExamRepository {
    @Override
    public boolean save(Exam exam) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pst = conn.prepareStatement(ADD_NEW_EXAM);
            pst.setInt(1, exam.getCourseId());
            pst.setString(2, exam.getExamTitle());
            pst.setDate(3, Date.valueOf(exam.getExamDate()));
            pst.setTime(4, Time.valueOf(exam.getExamTime()));
            return pst.executeUpdate() > 0;
        }
    }
}
