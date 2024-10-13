package repository;

import model.Student;
import model.Teacher;
import model.dto.TeacherStudentDto;

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

    List<TeacherStudentDto> getAllStudents() throws SQLException;

    Teacher getByIdAndNationalCode(int id, String nationalCode) throws SQLException;

    boolean grading(int studentId, int courseId , double avgScore) throws SQLException;
}
