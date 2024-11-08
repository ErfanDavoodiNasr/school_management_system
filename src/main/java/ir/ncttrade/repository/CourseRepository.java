package ir.ncttrade.repository;


import ir.ncttrade.base.BaseRepository;
import ir.ncttrade.model.Course;

import java.util.List;

public interface CourseRepository extends BaseRepository<Course, Integer> {
    @Override
    Course upsert(Course course);

    @Override
    Boolean remove(Integer integer);

    @Override
    Course findById(Integer integer);

    @Override
    List findAll();
}
