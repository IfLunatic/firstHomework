package patterns.task.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import patterns.task.*;
import patterns.task.CatalogClasses.AddMovie;
import patterns.task.CatalogClasses.CatalogOfMovies;
import patterns.task.CatalogClasses.MovieAdapter;
import patterns.task.CatalogClasses.SearchFilmInCatalog;
import patterns.task.HTML.CreateHTMLFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Menu {

    public static HashMap<String, String> loginHashMap = new HashMap<>();
    public static HashMap<String, Customer> registrHashMap = new HashMap<>();

    public static boolean programWorking = true;

    public static void menu(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        do {
            while (programWorking) {
                System.out.println("""
                                  |----------------------|
                                  |     What you need?   |
                                  |----------------------|
                        1. Show catalog films       2. Add new film
                        3. Search film              4. My information
                        5. Take a movie             6. My favorite movies
                                      7. Close program
                                  ------------------------
                        """);
                if (scanner.hasNextInt()) {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1 -> firstParagraph();
                        case 2 -> secondParagraph();
                        case 3 -> thirdParagraph();
                        case 4 -> fourthParagraph(customer);
                        case 5 -> fifthParagraph(customer);
                        case 6 -> sixthParagraph(customer);
                        case 7 -> closeProgram();
                        default -> System.out.println("You have entered an unavailable option");
                    }
                } else {
                    System.out.println("You entered an incorrect value. Please enter a whole number.");
                    scanner.next();
                }

            }
        } while (choose < 1 || choose > 7);
    }

    public static boolean closeProgram() {
        return programWorking = false;
    }

    private static void sixthParagraph(Customer customer) {
        CatalogOfMovies.outputUserFavoriteMovies(customer);
    }

    private static void fifthParagraph(Customer customer) {
        CatalogOfMovies.takeAMovie(customer);
    }

    public static void firstParagraph() {
        CatalogOfMovies.outputCatalog();
    }

    public static void secondParagraph() {
        AddMovie.addMovie();
    }

    public static void thirdParagraph() {
        SearchFilmInCatalog.searchFilm();
    }

    public static void fourthParagraph(Customer customer) {
        System.out.println(customer.statement());
        CreateHTMLFile.createHtml(customer);
    }


    public static void userSerializer() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("LoginPassword.json")) {
            gson.toJson(loginHashMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void userDeserializer() {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader("LoginPassword.json")) {
            Type movieListType = new TypeToken<HashMap<String, String>>() {
            }.getType();
            loginHashMap = gson.fromJson(reader, movieListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void customerSerializer() {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(MovieType.class, new MovieAdapter()).create();
        String json = gson.toJson(registrHashMap);
        try (FileWriter writer = new FileWriter("customer.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void customerDeserializer() {
        Gson gson = new GsonBuilder().registerTypeAdapter(MovieType.class, new MovieAdapter()).create();
        try (FileReader reader = new FileReader("customer.json")) {
            Type movieListType = new TypeToken<HashMap<String, Customer>>() {
            }.getType();
            registrHashMap = gson.fromJson(reader, movieListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
