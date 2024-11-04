package ir.ncttrade.repository.impl;

import ir.ncttrade.base.AbstractBaseRepository;
import ir.ncttrade.model.Student;
import ir.ncttrade.repository.StudentRepository;

public class StudentRepositoryImpl extends AbstractBaseRepository<Student, Integer> implements StudentRepository {
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public String getEntityQuery() {
        return "Student";
    }
}
