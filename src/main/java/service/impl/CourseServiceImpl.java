package service.impl;

import model.Course;
import model.Exam;
import repository.CourseRepository;
import service.CourseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseRepository cr;

    public CourseServiceImpl(CourseRepository cr) {
        this.cr = cr;
    }
    @Override
    public Course addCourse(Course course) throws SQLException {
        if (course == null) {
            throw new IllegalArgumentException("Course is null");
        }else{
            return cr.addCourse(course);
        }
    }

    @Override
    public boolean updateCourse(String courseTitle, Course newCourse) throws SQLException {
        if (cr.getCourse(courseTitle) == null || newCourse == null) {
            throw new IllegalArgumentException("Course does not exist");
        }else{
            return cr.updateCourse(newCourse);
        }
    }

    @Override
    public boolean deleteCourse(String courseTitle) throws SQLException {
        Course course = cr.getCourse(courseTitle);
        if (course == null) {
            throw new IllegalArgumentException("Course does not exist");
        }else{
            return cr.deleteCourse(course);
        }
    }

    @Override
    public Course generateCourse(String courseTitle, int courseUnit) throws SQLException {
        return new Course(courseTitle, courseUnit);
    }

    @Override
    public void printAllCourses() throws SQLException {
        List<Course> courses = cr.getAllCourses();
        System.out.printf("%-7s %-15s %-7s\n", "id", "course title", "course unit");
        for (Course course : courses) {
            System.out.printf("%-7s %-15s %-7s\n",
                    course.getCourseId(),
                    course.getCourseTitle(),
                    course.getCourseUnit());
        }
    }

    @Override
    public Course getCoursesByTitle(String courseTitle) throws SQLException {
        Course course = cr.getCourse(courseTitle);
        if (course == null) {
            throw new IllegalArgumentException("Course does not exist");
        }else {
            return course;
        }
    }

}
