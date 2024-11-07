package ir.ncttrade.handler;

import ir.ncttrade.base.BaseModel;
import ir.ncttrade.model.Student;
import ir.ncttrade.repository.impl.StudentRepositoryImpl;

import java.io.Serializable;
import java.util.List;

public class PrintAllStudent extends  Thread{

    private final StudentRepositoryImpl sr;

    public PrintAllStudent() {
        sr = new StudentRepositoryImpl();
    }

    @Override
    public void run() {
        List students = sr.findAll();
        while (true) {
            System.out.println(sr.getCountStudent());
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
