package ir.ncttrade.repository;

import ir.ncttrade.base.BaseRepository;
import ir.ncttrade.model.Course;

import java.util.List;

public interface CourseRepository {
    void update(Long oldCourseId, Course newCourse);
    List<Course> findAll();
}
