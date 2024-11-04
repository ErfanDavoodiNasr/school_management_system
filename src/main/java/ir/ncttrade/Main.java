package ir.ncttrade;


import ir.ncttrade.model.Student;
import ir.ncttrade.repository.impl.StudentRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Student s1 = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("0911123905929")
                .nationalCode("010123836184")
                .build();
        StudentRepositoryImpl sr = new StudentRepositoryImpl();
        Student s2 = sr.upsert(s1);
        System.out.println(s1);
    }
}
