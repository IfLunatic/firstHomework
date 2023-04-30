package patterns.task.menu;


import java.util.Scanner;

import static patterns.task.menu.Login.signIn;
import static patterns.task.menu.Login.signUp;
import static patterns.task.menu.Menu.closeProgram;

public class LoginMenu {
    public static void logMenu() {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        do {
                System.out.println("""
                        Choose variant
                1. Sign In          2. Sign Up
                        3. Close Program
                """);
                if (scanner.hasNextInt()) {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1 -> signIn();
                        case 2 -> signUp();
                        case 3 -> closeProgram();
                        default -> System.out.println("You have entered an unavailable option");
                    }
                } else {
                    System.out.println("You entered an incorrect value. Please enter a whole number.");
                    scanner.next();
                }
            } while (choose < 1 || choose > 3);
    }
}
