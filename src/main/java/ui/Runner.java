package ui;

import util.ApplicationContext;

import static util.Help.*;

public class Runner {

    public static void run() {
        while (true) {
            println("****welcome****");
            println("1 - sign in");
            println("2 - exit");
            Integer input = intInput("choose a number: ");
            switch (input) {
                case 1 -> signIn();
                case 2 -> System.exit(0);
                default -> println("choose a number between 1 and 2");
            }
        }
    }
    private static void signIn(){
        try {
            int id = intInput("enter id: ");
            String nationalCode = input("enter national code: ");
            generateRandomCode();
            ApplicationContext.getUserService().signIn(id,nationalCode);
        } catch (Exception e) {
            println(e.getMessage());
        }
    }


}
