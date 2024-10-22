package repository;

import model.Teacher;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    boolean save(T t) throws SQLException;

    boolean remove(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    Optional<List<T>> getAll() throws SQLException;
}
