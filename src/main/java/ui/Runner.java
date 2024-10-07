package ui;

import static ui.RunnerAdmin.adminMenu;
import static ui.RunnerAdmin.teacher;
import static ui.RunnerStudent.studentMenu;
import static util.Help.*;

public class Runner {

    public static void run() {
        while (true) {
            println("****welcome****");
            println("1 - student setting");
            println("2 - admin setting");
            println("3 - teacher setting");
            println("4 - exit");
            Integer input = intInput("choose a number: ");
            switch (input) {
                case 1 -> studentMenu();
                case 2 -> adminMenu();
                case 3 -> teacher(); // TODO
                case 4 -> System.exit(0);
                default -> println("choose a number between 1 and 3");
            }
        }
    }


}
