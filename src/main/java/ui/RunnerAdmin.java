package ui;

import model.Course;
import model.Exam;
import model.Student;
import model.Teacher;
import util.ApplicationContext;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static util.Help.*;
import static util.Help.println;

public class RunnerAdmin {



    public static void admin() {
        while (true) {
            println("****welcome****");
            println("1 - student setting");
            println("2 - teacher setting");
            println("3 - course setting");
            println("4 - exam setting");
            println("5 - return to last page");
            Integer input = intInput("choose a number: ");
            switch (input) {
                case 1 -> student();
                case 2 -> teacher();
                case 3 -> course();
                case 4 -> exam();
                case 5 -> {
                    return;
                }
                default -> println("choose a number between 1 and 4");
            }
        }
    }

    private static void exam() {
        while (true) {
            println("1 - add exam");
            println("2 - return to last page");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> addExam();
                case 2 -> {
                    return;
                }
                default -> println("enter a number between 1 and 2");
            }
        }
    }

    private static void addExam() {
        try {
            String courseTitle = input("enter course title: ");
            String examTitle = input("enter exam title: ");
            String examDate = input("enter exam date(2005-01-01): ");
            String examTime = input("enter exam time(12:30): ");
            int year = Integer.parseInt(examDate.substring(0, 4));
            int month = Integer.parseInt(examDate.substring(5, 7));
            int day = Integer.parseInt(examDate.substring(8, 10));
            int hour = Integer.parseInt(examTime.substring(0, 2));
            int minute = Integer.parseInt(examTime.substring(3, 5));

            if (ApplicationContext.getExamService().save(new Exam(
                    ApplicationContext.getCourseService().getByTitle(courseTitle).get().getCourseId(),
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

    private static void student() {
        while (true) {
            println("1 - add student");
            println("2 - update student");
            println("3 - delete student");
            println("4 - list students");
            println("5 - add course to student");
            println("6 - return to last page");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> addStudent();
                case 2 -> updateStudents();
                case 3 -> removeStudent();
                case 4 -> listStudents();
                case 5 -> saveCourseStudent();
                case 6 -> {
                    return;
                }
                default -> println("enter a number between 1 and 5");
            }
        }
    }

    private static void saveCourseStudent() {
        String courseTitle = input("enter course title:");
        Integer studentId = intInput("enter student id: ");
        try {
            if (ApplicationContext.getCoursesStudentService().save(courseTitle, studentId)) {
                println("course successfully added to student");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    static void teacher() {
        while (true) {
            println("1 - add teacher");
            println("2 - update teacher");
            println("3 - delete teacher");
            println("4 - list teacher");
            println("5 - add course to teacher");
            println("6 - return to last page");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> addTeacher();
                case 2 -> updateTeacher();
                case 3 -> removeTeacher();
                case 4 -> listTeachers();
                case 5 -> addCourseTeacher();
                case 6 -> {
                    return;
                }
                default -> println("enter a number between 1 and 5");
            }
        }
    }

    private static void addCourseTeacher() {
        String courseTitle = input("enter course title: ");
        String teacherNationalCode = input("enter teacher national code: ");
        try {
            if (ApplicationContext.getTeacherService().saveCourse(courseTitle, teacherNationalCode)) {
                println("course successfully added to teacher");
            }
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void course() {
        while (true) {
            println("1 - add course");
            println("2 - update course");
            println("3 - delete course");
            println("4 - list course");
            println("5 - return to last page");
            int input = intInput("choose a number: ");
            switch (input) {
                case 1 -> addCourse();
                case 2 -> updateCourse();
                case 3 -> removeCourse();
                case 4 -> listCourses();
                case 5 -> {
                    return;
                }
                default -> println("enter a number between 1 and 5");
            }
        }
    }

    static void addStudent() {
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            String birthDate = input("enter birth date(2005-01-01): ");
            String nationalCode = input("enter national code: ");
            String phoneNumber = input("enter phone number: ");
            int year = Integer.parseInt(birthDate.substring(0, 4));
            int month = Integer.parseInt(birthDate.substring(5, 7));
            int day = Integer.parseInt(birthDate.substring(8, 10));
            ApplicationContext.getStudentService().save(new Student(
                    firstName,
                    lastName,
                    LocalDate.of(year, month, day),
                    nationalCode,
                    phoneNumber,
                    LocalDate.now()
            ));
            println("Student added");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void addCourse() {
        try {
            String courseTitle = input("enter course title: ");
            int courseUnit = intInput("enter course unit: ");
            String examDate = input("enter exam date(2005-01-01): ");
            String examTime = input("enter exam time(12:30): ");
            int year = Integer.parseInt(examDate.substring(0, 4));
            int month = Integer.parseInt(examDate.substring(5, 7));
            int day = Integer.parseInt(examDate.substring(8, 10));
            int hour = Integer.parseInt(examTime.substring(0, 2));
            int minute = Integer.parseInt(examTime.substring(3, 5));
            ApplicationContext.getCourseService().save(new Course(courseTitle, courseUnit));
            ApplicationContext.getExamService().save(new Exam(ApplicationContext.getCourseService().getByTitle(courseTitle).get().getCourseId(),
                    courseTitle,
                    LocalDate.of(year, month, day),
                    LocalTime.of(hour, minute)
            ));
            println("exam and course successfully added");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void addTeacher() {
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            String nationalCode = input("enter national code: ");
            int courseId = intInput("enter course id: ");
            ApplicationContext.getTeacherService().save(new Teacher(firstName, lastName, nationalCode, courseId));
            println("Teacher added");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void removeStudent() {
        try {
            String nationalCode = input("enter national code: ");
            ApplicationContext.getStudentService().remove(nationalCode);
            println("Student removed");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void removeCourse() {
        try {
            String courseTitle = input("enter course title: ");
            ApplicationContext.getCourseService().remove(courseTitle);
            println("Course removed");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void removeTeacher() {
        try {
            String nationalCode = input("enter national code: ");
            ApplicationContext.getTeacherService().remove(nationalCode);
            println("Teacher removed");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void updateStudents() {
        try {
            String nationalCode = input("enter national code: ");
            if (ApplicationContext.getStudentService().getByNationalCode(nationalCode) == null) {
                println("Student not found");
                return;
            }
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            ApplicationContext.getStudentService().update(nationalCode, new Student(firstName, lastName, nationalCode));
            println("Student updated");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void updateCourse() {
        try {
            String courseTitle = input("enter course title: ");
            Optional<Course> course = ApplicationContext.getCourseService().getByTitle(courseTitle);
            if (course.isEmpty()) {
                println("Course not found");
                return;
            }
            int courseUnit = intInput("enter course unit: ");
            String newCourseTitle = input("enter course title: ");
            ApplicationContext.getCourseService().update(courseTitle, new Course(course.get().getCourseId(), newCourseTitle, courseUnit));
            println("Course updated");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void updateTeacher() {
        try {
            String nationalCode = input("enter national code: ");
            if (ApplicationContext.getTeacherService().getByNationalCode(nationalCode).isEmpty()) {
                println("Teacher not found");
                return;
            }
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            int courseId = intInput("enter courseId: ");
            ApplicationContext.getTeacherService().update(nationalCode, new Teacher(firstName, lastName, nationalCode, courseId));
            println("Teacher updated");
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void listStudents() {
        try {
            ApplicationContext.getStudentService().printAll();
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    private static void listTeachers() {
        try {
            ApplicationContext.getTeacherService().printAll();
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    public static void listCourses() {
        try {
            ApplicationContext.getCourseService().printAll();
        } catch (Exception e) {
            println(e.getMessage());
        }
    }
}
