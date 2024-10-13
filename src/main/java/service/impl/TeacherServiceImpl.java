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
import java.util.Optional;

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
        Optional<Teacher> optionalTeacher = Optional.empty();
        optionalTeacher = tr.getByNationalCode(nationalCode);
        if (optionalTeacher.isPresent()) {
            return tr.remove(optionalTeacher.get());
        }
        return false;
    }

    @Override
    public boolean update(String nationalCode, Teacher newTeacher) throws SQLException {
        if (tr.getByNationalCode(nationalCode).isEmpty() || newTeacher == null) {
            throw new IllegalArgumentException("Teacher does not exist");
        } else {
            return tr.update(newTeacher);
        }
    }

    @Override
    public void printAll() throws SQLException {
        Optional<List<Teacher>> teachers = tr.getAll();
        if (teachers.isPresent()) {


            System.out.printf("%-7s %-13s %-13s %-17s\n", "id", "first name", "last name", "national code");
            for (Teacher teacher : teachers.get()) {
                System.out.printf("%-7s %-13s %-13s %-17s\n",
                        teacher.getId(),
                        teacher.getFirst_name(),
                        teacher.getLast_name(),
                        teacher.getNationalCode());
            }
        } else {
            throw new IllegalArgumentException("Teacher list is empty");
        }
    }


    @Override
    public Optional<Teacher> getByNationalCode(String nationalCode) throws SQLException {
        return tr.getByNationalCode(nationalCode);
    }

    @Override
    public void printAllStudents() throws SQLException {
        Optional<List<TeacherStudentDto>> students = tr.getAllStudents();
        if (students.isPresent()) {
            System.out.printf("%-5s %-20s %-14s %-7s %-7s\n", "id", "full name", "national code", "score", "avg score");
            for (TeacherStudentDto student : students.get()) {
                System.out.printf("%-5s %-20s %-14s %-7s %-7s\n", student.getStudentId(), student.getFullName()
                        , student.getNationalCode(), student.getScore(), student.getAvgScore());
            }
        } else {
            throw new IllegalArgumentException("Student list is empty");
        }
    }

    @Override
    public boolean signIn(int teacherId, String nationalCode) throws SQLException {
        Optional<Teacher> teacher = tr.getByIdAndNationalCode(teacherId, nationalCode);
        if (teacher.isPresent()) {
            SecurityContext.teacher = teacher.get();
            return true;
        }
        return false;
    }

    @Override
    public boolean grading(String nationalCodeStudent, int courseId, double avgScore) throws SQLException {
        Optional<Student> student = sr.getByNationalCode(nationalCodeStudent);
        if (student.isEmpty()) {
            throw new IllegalArgumentException("Student does not exist");
        } else if (avgScore > 20.0 || avgScore < 0.0) {
            throw new IllegalArgumentException("Avg score cannot be more than 20.0 or less than 0.0");
        }
        return tr.grading(student.get().getId(), courseId, avgScore);
    }
}
