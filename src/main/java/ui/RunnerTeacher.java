package ui;

import model.Exam;
import model.Teacher;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static util.Help.*;

public class RunnerTeacher {


    public static void teacher() {
        while (true) {
            println("1 - show my students");
            println("2 - show my information");
            println("3 - grading the student");
            println("4 - edit information");
            println("5 - add exam");
            println("6 - exit");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> showMyStudents();
                case 2 -> showMyInformation();
                case 3 -> grading();
                case 4 -> editInformation();
                case 5 -> addExam();
                case 6 -> {
                    signOut();
                    return;
                }
                default -> println("choose a number between 1 and 4");
            }

        }
    }

    private static void addExam() {
        try {
            String examTitle = input("enter exam title: ");
            String examDate = input("enter exam date(2005-01-01): ");
            String examTime = input("enter exam time(12:30): ");
            int year = Integer.parseInt(examDate.substring(0, 4));
            int month = Integer.parseInt(examDate.substring(5, 7));
            int day = Integer.parseInt(examDate.substring(8, 10));
            int hour = Integer.parseInt(examTime.substring(0, 2));
            int minute = Integer.parseInt(examTime.substring(3, 5));

            if (ApplicationContext.getExamService().save(new Exam(
                    SecurityContext.teacher.getCourseId(),
                    examTitle,
                    LocalDate.of(year, month, day),
                    LocalTime.of(hour, minute)
            ))){
                println("exam successfully added");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void showMyInformation() {
        try {
            Optional<Teacher> optionalTeacher = ApplicationContext.getTeacherService().getByNationalCode(SecurityContext.teacher.getNationalCode());
            if (optionalTeacher.isPresent()) {
                Teacher teacher = optionalTeacher.get();
            System.out.printf("%-7s %-13s %-13s %-17s\n", "id", "first name", "last name", "national code");
            System.out.printf("%-7s %-13s %-13s %-17s\n",
                    teacher.getId(),
                    teacher.getFirst_name(),
                    teacher.getLast_name(),
                    teacher.getNationalCode());
            }else{
                println("No teacher found");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void editInformation() {
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            String nationalCode = SecurityContext.teacher.getNationalCode();
            ApplicationContext.getTeacherService().update(nationalCode, new Teacher(firstName, lastName, nationalCode));
            println("Teacher updated");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void grading() {
        try {
            String nationalCodeStudent = input("enter national code student: ");
            Double avgScore = doubleInput("enter avg score: ");
            ApplicationContext.getTeacherService().grading(nationalCodeStudent, SecurityContext.teacher.getCourseId(), avgScore);
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void showMyStudents() {
        try {
            ApplicationContext.getTeacherService().printAllStudents();
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void signOut() {
        if (SecurityContext.teacher == null) {
            println("you have not signed in");
        } else {
            SecurityContext.teacher = null;
            println("you have signe out successfully");
        }
    }

}
