package service.impl;

import model.Student;
import repository.StudentRepository;
import service.StudentService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository sr;

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
        Optional<Student> optionalStudent = Optional.empty();
        optionalStudent = sr.getByNationalCode(nationalCode);
        if (optionalStudent.isPresent()) {
            return sr.remove(optionalStudent.get());
        }
        return false;
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
        Optional<List<Student>> students = sr.getAll();
        if (students.isPresent()) {
        System.out.printf("%-7s %-13s %-13s %-17s %-7s\n", "id", "first name", "last name", "national code", "avg score");
        for (Student student : students.get()) {
            System.out.printf("%-7s %-13s %-13s %-17s %-7s\n",
                    student.getId(),
                    student.getFirst_name(),
                    student.getLast_name(),
                    student.getNationalCode(),
                    student.getAverageScore()
                    );

        }
        }else {
            throw new IllegalArgumentException("No students found");
        }
    }


    @Override
    public Optional<Student> getByNationalCode(String nationalCode) throws SQLException {
        return sr.getByNationalCode(nationalCode);
    }

    @Override
    public boolean signIn(int studentId, String nationalCode) throws SQLException {
        Optional<Student> student = sr.getByIdAndNationalCode(studentId,nationalCode);
        if (student.isPresent()) {
            SecurityContext.student = student.get();
            return true;
        }
        return false;
    }
}
