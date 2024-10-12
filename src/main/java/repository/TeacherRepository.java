package repository;

import model.Teacher;
import java.sql.SQLException;
import java.util.List;

public interface TeacherRepository {
    boolean save(Teacher teacher) throws SQLException;
    boolean remove(Teacher teacher) throws SQLException;
    boolean update(Teacher teacher) throws SQLException;
    List<Teacher> getAll() throws SQLException;
    Teacher getByNationalCode(String nationalCode) throws SQLException;
}
