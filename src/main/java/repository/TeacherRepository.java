package repository;

import model.Teacher;
import model.dto.TeacherStudentDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends BaseRepository<Teacher> {
    @Override
    boolean save(Teacher teacher) throws SQLException;

    @Override
    boolean remove(Teacher teacher) throws SQLException;

    @Override
    boolean update(Teacher teacher) throws SQLException;

    @Override
    Optional<List<Teacher>> getAll() throws SQLException;

    boolean saveCourse(int courseId, int teacherId) throws SQLException;

    Optional<Teacher> getByNationalCode(String nationalCode) throws SQLException;

    Optional<List<TeacherStudentDto>> getAllStudents() throws SQLException;

    Optional<Teacher> getByIdAndNationalCode(int id, String nationalCode) throws SQLException;

    boolean grading(int studentId, int courseId, double avgScore) throws SQLException;
}
