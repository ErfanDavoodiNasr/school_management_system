package ui;

import model.Teacher;
import util.ApplicationContext;
import util.SecurityContext;

import static util.Help.*;

public class RunnerTeacher {

    public static void teacherMenu() {
        while (true) {
            println("1 - sign in");
            println("2 - sign up");
            println("3 - sign out");
            Integer input = intInput("choose a number: ");
            switch (input) {
                case 1 -> signIn();
                case 2 -> signUp();
                case 3 -> {
                    signOut();
                    return;
                }
                default -> println("choose a number between 1 and 3");
            }
        }
    }

    public static void teacher() {
        while (true) {
            println("1 - show my students");
            println("2 - show my information");
            println("3 - grading the student");
            println("4 - edit information");
            println("5 - exit");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> showMyStudents();
                case 2 -> showMyInformation();
                case 3 -> grading();
                case 4 -> editInformation();
                case 5 -> {
                    signOut();
                    return;
                }
                default -> println("choose a number between 1 and 4");
            }

        }
    }

    private static void showMyInformation() {
        try {
            Teacher teacher = ApplicationContext.getTeacherService().getByNationalCode(SecurityContext.teacher.getNationalCode());
            System.out.printf("%-7s %-13s %-13s %-17s\n", "id", "first name", "last name", "national code");
            System.out.printf("%-7s %-13s %-13s %-17s\n",
                    teacher.getId(),
                    teacher.getFirst_name(),
                    teacher.getLast_name(),
                    teacher.getNationalCode());
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void editInformation() {
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            int courseId = intInput("enter courseId: ");
            String nationalCode = SecurityContext.teacher.getNationalCode();
            ApplicationContext.getTeacherService().update(nationalCode, new Teacher(firstName, lastName, nationalCode, courseId));
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

    private static void signUp() {
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            String nationalCode = input("enter national code: ");
            int courseId = intInput("enter course id: ");
            boolean result = ApplicationContext.getTeacherService().save(new Teacher(firstName, lastName, nationalCode, courseId));
            if (result) {
                println("teacher created successfully");
            } else {
                println("teacher could not be created");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void signIn() {
        try {
            int i = intInput("enter teacher id: ");
            String input = input("enter national code: ");
            generateRandomCode();
            if (ApplicationContext.getTeacherService().signIn(i, input)) {
                println("teacher sign in success");
                teacher();
                return;
            }
            println("your password or username is wrong");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }
}
