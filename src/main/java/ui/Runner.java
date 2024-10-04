package ui;
import model.Course;
import model.Student;
import model.Teacher;
import util.ApplicationContext;

import static util.Help.*;
public class Runner {

    public static void run(){
        while (true) {
            println("****welcome****");
            println("1 - student setting");
            println("2 - teacher setting");
            println("3 - course setting");
            println("4 - exam setting");
            println("5 - exit");
            Integer input = intInput("choose a number: ");
            switch(input){
                case 1 -> student();
                case 2 -> teacher();
                case 3 -> course();
                case 4 -> teacher(); // TODO
                case 5 -> System.exit(0);
                default -> println("choose a number between 1 and 5");
            }
        }
    }

    private static void student(){
        while (true) {
            println("1 - add student");
            println("2 - update student");
            println("3 - delete student");
            println("4 - list students");
            println("5 - exit");
            int input = intInput("choose a number: ");
            switch(input){
                case 1 -> addStudent();
                case 2 -> updateStudents();
                case 3 -> removeStudent();
                case 4 -> listStudents();
                case 5 -> {
                    return;
                }
                default -> println("enter a number between 1 and 5");
            }
        }
    }

    private static void teacher(){
        while (true) {
            println("1 - add teacher");
            println("2 - update teacher");
            println("3 - delete teacher");
            println("4 - list teacher");
            println("5 - exit");
            int input = intInput("choose a number: ");
            switch(input){
                case 1 -> addTeacher();
                case 2 -> updateTeacher();
                case 3 -> removeTeacher();
                case 4 -> listTeachers();
                case 5 -> {
                    return;
                }
                default -> println("enter a number between 1 and 5");
            }
        }
    }

    private static void course(){
        while (true) {
            println("1 - add course");
            println("2 - update course");
            println("3 - delete course");
            println("4 - list course");
            println("5 - exit");
            int input = intInput("choose a number: ");
            switch(input){
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

    private static void addStudent(){
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            String nationalCode = input("enter national code: ");
            ApplicationContext.getStudentService().addStudent(new Student(firstName,lastName,nationalCode));
            println("Student added");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void addCourse(){
        try {
            String courseTitle = input("enter course title: ");
            int courseUnit = intInput("enter course unit: ");
            ApplicationContext.getCourseService().addCourse(new Course(courseTitle,courseUnit));
            println("Course added");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void addTeacher(){
        try {
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            String nationalCode = input("enter national code: ");
            ApplicationContext.getTeacherService().addTeacher(new Teacher(firstName,lastName,nationalCode));
            println("Teacher added");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void removeStudent(){
        try {
            String nationalCode = input("enter national code: ");
            ApplicationContext.getStudentService().removeStudent(nationalCode);
            println("Student removed");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void removeCourse(){
        try {
            String courseTitle = input("enter course title: ");
            ApplicationContext.getCourseService().deleteCourse(courseTitle);
            println("Course removed");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void removeTeacher(){
        try {
            String nationalCode = input("enter national code: ");
            ApplicationContext.getTeacherService().removeTeacher(nationalCode);
            println("Teacher removed");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void updateStudents(){
        try {
            String nationalCode = input("enter national code: ");
            if (ApplicationContext.getStudentService().getStudentByNationalCode(nationalCode) == null) {
                println("Student not found");
                return;
            }
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            ApplicationContext.getStudentService().updateStudent(nationalCode,new Student(firstName,lastName,nationalCode));
            println("Student updated");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void updateCourse(){
        try {
            String courseTitle = input("enter course title: ");
            if (ApplicationContext.getCourseService().getCoursesByTitle(courseTitle) == null) {
                println("Course not found");
                return;
            }
            int courseUnit = intInput("enter course unit: ");
            String newCourseTitle = input("enter course title: ");
            ApplicationContext.getCourseService().updateCourse(courseTitle,new Course(newCourseTitle,courseUnit));
            println("Course updated");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void updateTeacher(){
        try {
            String nationalCode = input("enter national code: ");
            if (ApplicationContext.getTeacherService().getTeacherByNationalCode(nationalCode) == null) {
                println("Teacher not found");
                return;
            }
            String firstName = input("enter first name: ");
            String lastName = input("enter last name: ");
            ApplicationContext.getTeacherService().updateTeacher(nationalCode,new Teacher(firstName,lastName,nationalCode));
            println("Teacher updated");
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void listStudents(){
        try {
            ApplicationContext.getStudentService().printAllStudents();
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void listTeachers(){
        try {
            ApplicationContext.getTeacherService().printAllTeachers();
        }catch (Exception e){
            println(e.getMessage());
        }
    }

    private static void listCourses(){
        try {
            ApplicationContext.getCourseService().printAllCourses();
        }catch (Exception e){
            println(e.getMessage());
        }
    }

}
