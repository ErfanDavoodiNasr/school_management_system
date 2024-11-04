package ir.ncttrade.repository.impl;

import ir.ncttrade.base.AbstractBaseRepository;
import ir.ncttrade.model.Course;
import ir.ncttrade.repository.CourseRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static ir.ncttrade.util.EntityManagerProvider.getEntityManager;

public class CourseRepositoryImpl extends AbstractBaseRepository<Course,Integer> implements CourseRepository {

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public String getEntityQuery() {
        return "Course";
    }
}
