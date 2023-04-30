package patterns.task.menu;

import patterns.task.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Login {
    public static void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input login: ");
        String login = scanner.nextLine();

        if (Menu.loginHashMap.containsKey(login)) {
            System.out.println("Input password: ");
            String password = scanner.nextLine();
            if (Menu.loginHashMap.containsValue(password)) {
                Customer customer = Menu.registrHashMap.get(login);
                Menu.menu(customer);
                Menu.userSerializer();
            }
        } else {
            System.out.println("No user found, please register");
            signUp();
        }
        Menu.customerSerializer();
    }

    public static void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input login:");
        String login = scanner.nextLine();
        if (!Menu.registrHashMap.containsKey(login)) {
            System.out.println("Login is not busy.");

            System.out.println("Input password:");
            String password = scanner.nextLine();
            Menu.loginHashMap.put(login, password);

            System.out.println("Congratulations you have registered\nNow log in to your profile");

            Customer customer = new Customer(login, new ArrayList<>(), new HashSet<>(), 0, 0);
            Menu.registrHashMap.put(login, customer);
            Menu.userSerializer();
            Login.signIn();
        } else {
            System.out.println("Sign in, you already have account");
            Login.signIn();
        }
    }
}
