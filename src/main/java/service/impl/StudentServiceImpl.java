package service.impl;

import model.Student;
import repository.StudentRepository;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository sr;

    public StudentServiceImpl(StudentRepository sr) {
        this.sr = sr;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        return sr.addStudent(student);
    }

    @Override
    public boolean removeStudent(String nationalCode) throws SQLException {
        return sr.removeStudent(sr.getStudentByNationalCode(nationalCode));
    }

    @Override
    public boolean updateStudent(String nationalCode, Student newStudent) throws SQLException {
        if (newStudent == null) {
            throw new IllegalArgumentException("Student does not exist");
        }else {
            return sr.updateStudent(newStudent);
        }
    }


    @Override
    public void printAllStudents() throws SQLException {
        List<Student> students = sr.getAllStudents();
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
    public Student generateStudent(String firstName, String lastName, String nationalCode) throws SQLException {
        if (sr.getStudentByNationalCode(nationalCode) != null) {
            throw new IllegalArgumentException("Student already exists");
        } else {
            return new Student(firstName, lastName, nationalCode);
        }
    }

    @Override
    public Student getStudentByNationalCode(String nationalCode) throws SQLException {
        return sr.getStudentByNationalCode(nationalCode);
    }
}
