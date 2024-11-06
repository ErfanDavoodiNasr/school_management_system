package ir.ncttrade.service.impl;

import ir.ncttrade.model.Student;
import ir.ncttrade.repository.impl.StudentRepositoryImpl;
import ir.ncttrade.service.StudentService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    private final StudentRepositoryImpl sr;

    public StudentServiceImpl() {
        sr = new StudentRepositoryImpl();
    }

    @Override
    public Student upsert(Student student) {
        if (student != null) {
            return sr.upsert(student);
        }
        return null;
    }

    @Override
    public Boolean remove(Integer id) {
        if (id != null && id > 0) {
            return sr.remove(id);
        }
        return Boolean.FALSE;
    }

    @Override
    public Student findById(Integer id) {
        if (id != null && id > 0) {
            return sr.findById(id);
        }
        return null;
    }

    @Override
    public void printAllStudents() throws InterruptedException {
        List students = sr.findAll();
        while (true) {
            System.out.printf("%-7s %-13s %-13s %-17s %-7s\n", "id", "first name", "last name", "national code", "avg score");
            for (int i = 0; i < students.size(); i++) {
                Student student = (Student) students.get(i);
                System.out.printf("%-7s %-13s %-13s %-17s %-7s\n",
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getNationalCode(),
                        student.getAverageScore()
                );
            }
            Thread.sleep(5_000);
        }
    }
}
