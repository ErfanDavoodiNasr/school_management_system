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
    public boolean addTeacher(Teacher teacher) throws SQLException {
        if (teacher == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        return tr.addTeacher(teacher);
    }

    @Override
    public boolean removeTeacher(String nationalCode) throws SQLException {
        return tr.removeTeacher(tr.getTeacherNationalCode(nationalCode));
    }

    @Override
    public boolean updateTeacher(String nationalCode, Teacher newTeacher) throws SQLException {
        if (tr.getTeacherNationalCode(nationalCode) == null || newTeacher == null) {
            throw new IllegalArgumentException("Teacher does not exist");
        }else {
            return tr.updateTeacher(newTeacher);
        }
    }

    @Override
    public void printAllTeachers() throws SQLException {
        List<Teacher> teachers = tr.getAllTeachers();
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
    public Teacher generateTeacher(String firstName, String lastName, String nationalCode) throws SQLException {
        if (tr.getTeacherNationalCode(nationalCode) != null) {
            throw new IllegalArgumentException("Teacher already exists");
        } else {
            return new Teacher(firstName, lastName, nationalCode);
        }
    }

    @Override
    public Teacher getTeacherByNationalCode(String nationalCode) throws SQLException {
        return tr.getTeacherNationalCode(nationalCode);
    }
}
