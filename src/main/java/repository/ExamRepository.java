package repository;

import model.Exam;

import java.sql.SQLException;
import java.util.List;

public interface ExamRepository {
    boolean addExam(Exam exam) throws SQLException;
}
