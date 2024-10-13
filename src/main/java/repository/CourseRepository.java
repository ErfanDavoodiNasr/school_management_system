package repository;

import model.Course;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends BaseRepository<Course> {
    @Override
    boolean save(Course course) throws SQLException;

    @Override
    boolean remove(Course course) throws SQLException;

    @Override
    boolean update(Course course) throws SQLException;

    @Override
    Optional<List<Course>> getAll() throws SQLException;

    Optional<Course> getByTitle(String courseTitle) throws SQLException;
}
