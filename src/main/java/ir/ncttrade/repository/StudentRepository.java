package ir.ncttrade.repository;

import ir.ncttrade.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findByNationalCode(String nationalCode);
    Integer getCountStudent();
}
