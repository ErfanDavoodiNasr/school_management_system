package ir.ncttrade;


import ir.ncttrade.service.StudentService;
import ir.ncttrade.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StudentService ss = new StudentServiceImpl();
        ss.printAllStudents();
    }
}
