package service.impl;

import model.Student;
import repository.StudentRepository;
import service.StudentService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository sr;

    public StudentServiceImpl(StudentRepository sr) {
        this.sr = sr;
    }

    @Override
    public boolean save(Student student) throws SQLException {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        SecurityContext.student = student;
        return sr.save(student);
    }

    @Override
    public boolean remove(String nationalCode) throws SQLException {
        return sr.remove(sr.getByNationalCode(nationalCode));
    }

    @Override
    public boolean update(String nationalCode, Student newStudent) throws SQLException {
        if (newStudent == null) {
            throw new IllegalArgumentException("Student does not exist");
        }else {
            return sr.update(newStudent);
        }
    }


    @Override
    public void printAll() throws SQLException {
        List<Student> students = sr.getAll();
        System.out.printf("%-7s %-13s %-13s %-17s\n", "id", "first name", "last name", "national code");
        for (Student student : students) {
            System.out.printf("%-7s %-13s %-13s %-17s\n",
                    student.getId(),
                    student.getFirst_name(),
                    student.getLast_name(),
                    student.getNationalCode());
        }
    }


    @Override
    public Student getByNationalCode(String nationalCode) throws SQLException {
        return sr.getByNationalCode(nationalCode);
    }

    @Override
    public boolean signIn(int studentId, String nationalCode) throws SQLException {
        Student student = sr.getByIdAndNationalCode(studentId,nationalCode);
        if (student != null) {
            SecurityContext.student = student;
            return true;
        }
        return false;
    }
}
