package ir.ncttrade.repository.impl;

import ir.ncttrade.base.AbstractBaseRepository;
import ir.ncttrade.model.Teacher;
import ir.ncttrade.repository.TeacherRepository;

public class TeacherRepositoryImpl extends AbstractBaseRepository<Teacher,Integer> implements TeacherRepository {
    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }

    @Override
    public String getEntityQuery() {
        return "Teacher";
    }
}
