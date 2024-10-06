package ui;

import model.dto.CourseDto;
import util.ApplicationContext;
import util.SecurityContext;

import java.util.List;

import static ui.RunnerAdmin.addStudent;
import static util.Help.*;

public class RunnerStudent {

    public static void studentMenu() {
        while (true) {
            println("1 - sign in");
            println("2 - sign up");
            println("3 - sign out");
            Integer input = intInput("choose a number: ");
            switch (input) {
                case 1 -> signInStudent();
                case 2 -> addStudent();
                case 3 -> {
                    signOutStudent();
                    return;
                }
                default -> println("choose a number between 1 and 4");
            }
        }
    }

    public static void student() {
        while (true) {
            println("1 - add course");
            println("2 - remove course");
            println("3 - show my courses");
            println("4 - show all courses");
            println("5 - exit");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> addCourseStudent();
                case 2 -> removeCourseStudent();
                case 3 -> showMyCourses();
                case 4 -> showAllCoursesStudent();
                case 5 -> signOutStudent();
                default -> println("choose a number between 1 and 5");
            }

        }
    }

    private static void showAllCoursesStudent() {
        try {
            List<CourseDto> courses =ApplicationContext.getCoursesStudentService().getAllCourses();
            System.out.printf("%-13s %-5s %-20s %-13s %-13s\n","title","credit","teacher", "date","time");
            for (CourseDto course : courses) {
                System.out.printf("%-13s %-5s %-20s %-13s %-13s\n",course.getCourseTitle(),course.getCourseUnit(),course.getTeacherName(), course.getExamDate(),course.getExamTime());
            }
        }catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void updateInfo() {
    }

    public static void showMyCourses() {
        try {
            List<CourseDto> courses = ApplicationContext.getCoursesStudentService().getCourses();
            System.out.printf("%-13s %-5s %-20s %-13s %-13s\n","title","credit","teacher", "date","time");
            for (CourseDto course : courses) {
                System.out.printf("%-13s %-5s %-20s %-13s %-13s\n",course.getCourseTitle(),course.getCourseUnit(),course.getTeacherName(), course.getExamDate(),course.getExamTime());
            }
        }catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void removeCourseStudent() {
        // TODO
    }

    private static void addCourseStudent() {
        try{
            String input = input("enter course title: ");
            if (ApplicationContext.getCoursesStudentService().addCourse(input)){
                println("Course added");
            }else {
                println("Course not added");
            }
        }catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void signOutStudent() {
        if (SecurityContext.student == null) {
            println("you have not signed in");
        }else{
            SecurityContext.student = null;
            println("you have signe out successfully");
        }
    }

    public static void signInStudent() {
        try {
            int i = intInput("enter student id: ");
            String input = input("enter national code: ");
            if (ApplicationContext.getStudentService().signIn(i, input)) {
                println("student sign in success");
                student();
                return;
            }
            println("your password or username is wrong");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

}
