package repository;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T> {
    boolean save(T t) throws SQLException;
    boolean remove(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    List<T> getAll() throws SQLException;
}
