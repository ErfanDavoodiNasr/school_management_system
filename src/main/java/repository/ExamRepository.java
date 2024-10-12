package repository;

import model.Exam;

import java.sql.SQLException;

public interface ExamRepository {
    boolean save(Exam exam) throws SQLException;
}
