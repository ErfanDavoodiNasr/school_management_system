package service.impl;

import model.Teacher;
import repository.TeacherRepository;
import service.TeacherService;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository tr;

    public TeacherServiceImpl(TeacherRepository tr) {
        this.tr = tr;
    }

    @Override
    public boolean save(Teacher teacher) throws SQLException {
        if (teacher == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        return tr.save(teacher);
    }

    @Override
    public boolean remove(String nationalCode) throws SQLException {
        return tr.remove(tr.getByNationalCode(nationalCode));
    }

    @Override
    public boolean update(String nationalCode, Teacher newTeacher) throws SQLException {
        if (tr.getByNationalCode(nationalCode) == null || newTeacher == null) {
            throw new IllegalArgumentException("Teacher does not exist");
        }else {
            return tr.update(newTeacher);
        }
    }

    @Override
    public void printAll() throws SQLException {
        List<Teacher> teachers = tr.getAll();
        System.out.printf("%-7s %-13s %-13s %-17s\n", "id", "first name", "last name", "national code");
        for (Teacher teacher : teachers) {
            System.out.printf("%-7s %-13s %-13s %-17s\n",
                    teacher.getId(),
                    teacher.getFirst_name(),
                    teacher.getLast_name(),
                    teacher.getNationalCode());
        }
    }


    @Override
    public Teacher getByNationalCode(String nationalCode) throws SQLException {
        return tr.getByNationalCode(nationalCode);
    }
}
