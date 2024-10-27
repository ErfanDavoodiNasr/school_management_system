package ui;

import model.Student;
import model.dto.CertificateDto;
import model.dto.CourseDto;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static util.Help.*;

public class RunnerStudent {

    public static void student() {
        while (true) {
            println("1 - add course");
            println("2 - remove course");
            println("3 - show my courses");
            println("4 - show all courses");
            println("5 - show my certificate");
            println("6 - exit");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> addCourse();
                case 2 -> removeCourse();
                case 3 -> showMyCourses();
                case 4 -> showAllCourses();
                case 5 -> showMyCertificate();
                case 6 -> {
                    signOut();
                    return;
                }
                default -> println("choose a number between 1 and 5");
            }

        }
    }

    private static void showMyCertificate() {
        try {
            Optional<List<CertificateDto>> certificate = ApplicationContext.getCoursesStudentService().certificate();
            System.out.printf("%-13s %-5s\n", "title", "score");
            for (CertificateDto item : certificate.get()) {
                System.out.printf("%-13s %-5s\n", item.getCourseTitle(), item.getScore());
            }
            println("");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void showAllCourses() {
        try {
            Optional<List<CourseDto>> courses = ApplicationContext.getCoursesStudentService().getAll();
            System.out.printf("%-13s %-5s %-20s %-13s %-13s\n", "title", "credit", "teacher", "date", "time");
            for (CourseDto course : courses.get()) {
                System.out.printf("%-13s %-5s %-20s %-13s %-13s\n", course.getCourseTitle(), course.getCourseUnit(), course.getTeacherName(), course.getExamDate(), course.getExamTime());
            }
            println("");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void updateInfo() {
    }

    public static void showMyCourses() {
        try {
            Optional<List<CourseDto>> courses = ApplicationContext.getCoursesStudentService().getAllUserCourses();
            if (courses.isEmpty()) {
                println("there is no courses");
                return;
            }
            System.out.printf("%-13s %-5s %-20s %-13s %-13s %-7s\n", "title", "credit", "teacher", "date", "time", "avg score");
            for (CourseDto course : courses.get()) {
                System.out.printf("%-13s %-5s %-20s %-13s %-13s %-7s\n", course.getCourseTitle(), course.getCourseUnit(), course.getTeacherName(), course.getExamDate(), course.getExamTime(), course.getAvgScore());
            }
            println("");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void removeCourse() {
        try {
            String input = input("enter course title: ");
            if (ApplicationContext.getCoursesStudentService().remove(input)) {
                println("Course removed");
            } else {
                println("Course not removed");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void addCourse() {
        try {
            String input = input("enter course title: ");
            if (ApplicationContext.getCoursesStudentService().save(input, SecurityContext.student.getId())) {
                println("Course added");
            } else {
                println("Course not added");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void signOut() {
        if (SecurityContext.student == null) {
            println("you have not signed in");
        } else {
            SecurityContext.student = null;
            println("you have signe out successfully");
        }
    }


}
