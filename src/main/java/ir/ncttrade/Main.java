package ir.ncttrade;


import ir.ncttrade.handler.PrintAllStudent;
import ir.ncttrade.model.Address;
import ir.ncttrade.model.Field;
import ir.ncttrade.model.Student;
import ir.ncttrade.repository.impl.StudentRepositoryImpl;
import ir.ncttrade.service.StudentService;
import ir.ncttrade.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        Student s1 = Student.builder()
                .firstName("agha toto")
                .lastName("jazab")
                .nationalCode("123456789")
                .phoneNumber("09113784645")
                .email("toto@gmail.com")
                .build();


//        Thread thread = new PrintAllStudent();
//        thread.start();

    }
}
