package service.impl;

import model.Student;
import model.Teacher;
import model.dto.TeacherStudentDto;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.TeacherService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository tr;
    private final StudentRepository sr;

    public TeacherServiceImpl(TeacherRepository tr, StudentRepository sr) {
        this.tr = tr;
        this.sr = sr;
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
        } else {
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

    @Override
    public void printAllStudents() throws SQLException {
        List<TeacherStudentDto> students = tr.getAllStudents();
        System.out.printf("%-5s %-20s %-14s %-5s\n", "id", "full name", "national code", "avg score");
        for (TeacherStudentDto student : students) {
            System.out.printf("%-5s %-20s %-14s %-5s\n", student.getStudentId(), student.getFullName()
                    , student.getNationalCode(), student.getAvgScore());
        }
    }

    @Override
    public boolean signIn(int teacherId, String nationalCode) throws SQLException {
        Teacher teacher = tr.getByIdAndNationalCode(teacherId,nationalCode);
        if (teacher != null) {
            SecurityContext.teacher = teacher;
            return true;
        }
        return false;
    }

    @Override
    public boolean grading(String nationalCodeStudent, double avgScore) throws SQLException {
        Student student = sr.getByNationalCode(nationalCodeStudent);
        if (student == null) {
            throw new IllegalArgumentException("Student does not exist");
        } else if (avgScore > 20.0 || avgScore < 0.0) {
            throw new IllegalArgumentException("Avg score cannot be more than 20.0 or less than 0.0");
        }
        return tr.grading(nationalCodeStudent,avgScore);
    }
}
