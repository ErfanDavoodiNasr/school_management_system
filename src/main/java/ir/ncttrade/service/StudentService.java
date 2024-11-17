package ir.ncttrade.service;

import ir.ncttrade.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student upsert(Student student);
    Boolean remove(Integer id);
    Student findById(Integer id);
    void printAllStudents() throws InterruptedException;
}
