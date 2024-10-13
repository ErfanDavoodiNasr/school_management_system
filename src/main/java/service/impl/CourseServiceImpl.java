package service.impl;

import model.Course;
import repository.CourseRepository;
import service.CourseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    private CourseRepository cr;

    public CourseServiceImpl(CourseRepository cr) {
        this.cr = cr;
    }
    @Override
    public boolean save(Course course) throws SQLException {
        if (course == null) {
            throw new IllegalArgumentException("Course is null");
        }else{
            return cr.save(course);
        }
    }

    @Override
    public boolean update(String courseTitle, Course newCourse) throws SQLException {
        if (cr.getByTitle(courseTitle).isEmpty() || newCourse == null) {
            throw new IllegalArgumentException("Course does not exist");
        }else{
            return cr.update(newCourse);
        }
    }

    @Override
    public boolean remove(String courseTitle) throws SQLException {
        Optional<Course> course = cr.getByTitle(courseTitle);
        if (course.isEmpty()) {
            throw new IllegalArgumentException("Course does not exist");
        }else{
            return cr.remove(course.get());
        }
    }


    @Override
    public void printAll() throws SQLException {
        Optional<List<Course>> courses = cr.getAll();
        if (courses.isEmpty()) {
            throw new IllegalArgumentException("Course list is empty");
        }
        System.out.printf("%-7s %-15s %-7s\n", "id", "course title", "course unit");
        for (Course course : courses.get()) {
            System.out.printf("%-7s %-15s %-7s\n",
                    course.getCourseId(),
                    course.getCourseTitle(),
                    course.getCourseUnit());
        }
    }

    @Override
    public Optional<Course> getByTitle(String courseTitle) throws SQLException {
        Optional<Course> course = cr.getByTitle(courseTitle);
        if (course.isEmpty()) {
            throw new IllegalArgumentException("Course does not exist");
        }else {
            return course;
        }
    }

}
