package service;

import model.Exam;

import java.sql.SQLException;

public interface ExamService {
    boolean save(Exam exam) throws SQLException;
}
