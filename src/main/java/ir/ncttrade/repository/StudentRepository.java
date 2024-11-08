package ir.ncttrade.repository;

import ir.ncttrade.base.BaseRepository;
import ir.ncttrade.model.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student,Integer> {
    List<Student> findByNationalCode(String nationalCode);
    Integer getCountStudent();
}
