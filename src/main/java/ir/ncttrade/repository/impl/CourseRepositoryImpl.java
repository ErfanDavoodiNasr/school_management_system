package ir.ncttrade.repository.impl;

import ir.ncttrade.base.AbstractBaseRepository;
import ir.ncttrade.model.Course;
import ir.ncttrade.repository.CourseRepository;
import java.util.List;

public class CourseRepositoryImpl extends AbstractBaseRepository<Course,Integer> implements CourseRepository {

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public void update(Long oldCourseId, Course newCourse) {

    }

    @Override
    public List<Course> findAll() {
        return List.of();
    }
}
