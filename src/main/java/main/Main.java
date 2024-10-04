package main;


import model.Exam;
import util.ApplicationContext;

import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;


public class Main {
    public static void main(String[] args)  {
        try{
            ApplicationContext.getExamService().addExam(
                    new Exam(
                            1,
                            "azmoon riazi",
                            LocalDate.of(2005,1,1),
                            LocalTime.of(1,30)
                    )
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
