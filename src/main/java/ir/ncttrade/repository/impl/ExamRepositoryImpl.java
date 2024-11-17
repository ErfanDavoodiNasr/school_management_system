package ir.ncttrade.repository.impl;

import ir.ncttrade.base.AbstractBaseRepository;
import ir.ncttrade.model.Exam;
import ir.ncttrade.repository.ExamRepository;

public class ExamRepositoryImpl extends AbstractBaseRepository<Exam, Integer> implements ExamRepository{
    @Override
    public Class<Exam> getEntityClass() {
        return Exam.class;
    }

    @Override
    public String getEntityQuery() {
        return "Exam";
    }
}
