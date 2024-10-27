package service.impl;

import exception.UserNotFoundException;
import repository.UserRepository;
import service.UserService;
import util.ApplicationContext;

import javax.lang.model.util.ElementScanner6;
import java.sql.SQLException;

import static ui.RunnerAdmin.admin;
import static ui.RunnerStudent.student;
import static ui.RunnerTeacher.teacher;
import static util.Help.println;

public class UserServiceImpl implements UserService {
    private UserRepository ur;

    public UserServiceImpl(UserRepository ur) {
        this.ur = ur;
    }

    @Override
    public void signIn(Integer id, String nationalCode) throws SQLException {
        String role = ur.getRoleByNationalCode(nationalCode);
        switch (role) {
            case "ADMIN" -> {
                if (ApplicationContext.getAdminService().signIn(id, nationalCode)) {
                    println("admin successfully logged in");
                    admin();
                } else {
                    throw new UserNotFoundException("your id or nationalCode is wrong");
                }
            }
            case "STUDENT" -> {
                if (ApplicationContext.getStudentService().signIn(id, nationalCode)) {
                    println("student successfully logged in");
                    student();
                } else {
                    throw new UserNotFoundException("your id or nationalCode is wrong");
                }
            }
            case "TEACHER" -> {
                if (ApplicationContext.getTeacherService().signIn(id, nationalCode)) {
                    println("teacher successfully logged in");
                    teacher();
                } else {
                    throw new UserNotFoundException("your id or nationalCode is wrong");
                }
            }
            default -> {
                throw new UserNotFoundException("your id or nationalCode is wrong");
            }
        }
    }


}
