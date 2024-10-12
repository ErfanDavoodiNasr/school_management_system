package service.impl;

import model.Exam;
import repository.ExamRepository;
import service.ExamService;

import java.sql.SQLException;

public class ExamServiceImpl implements ExamService {
    private ExamRepository er;

    public ExamServiceImpl(ExamRepository er) {
        this.er = er;
    }

    @Override
    public boolean save(Exam exam) throws SQLException {
        if (exam == null) {
            throw new IllegalArgumentException("exam is null");
        }else {
            return er.save(exam);
        }
    }
}
