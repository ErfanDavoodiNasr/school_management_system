package repository;

import model.Teacher;
import java.sql.SQLException;
import java.util.List;

public interface TeacherRepository extends BaseRepository<Teacher> {
    @Override
    boolean save(Teacher teacher) throws SQLException;

    @Override
    boolean remove(Teacher teacher) throws SQLException;

    @Override
    boolean update(Teacher teacher) throws SQLException;

    @Override
    List<Teacher> getAll() throws SQLException;

    Teacher getByNationalCode(String nationalCode) throws SQLException;

}
