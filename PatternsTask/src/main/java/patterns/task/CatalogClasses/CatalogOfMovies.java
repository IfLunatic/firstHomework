package patterns.task.CatalogClasses;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import patterns.task.*;
import patterns.task.menu.Menu;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;



public class CatalogOfMovies {


    public static List<Movie> catalogOfMovies = new ArrayList<>();

    public static void movieSerializer() {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(MovieType.class, new MovieAdapter()).create();
        String json = gson.toJson(catalogOfMovies);
        try (FileWriter writer = new FileWriter("catalog.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void movieDeserializer() {
        Gson gson = new GsonBuilder().registerTypeAdapter(MovieType.class, new MovieAdapter()).create();
        try (FileReader reader = new FileReader("catalog.json")) {
            Type movieListType = new TypeToken<List<Movie>>() {}.getType();
            catalogOfMovies = gson.fromJson(reader, movieListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void outputCatalog() {
        movieDeserializer();
        movieSerializer();
        for (Movie movie : catalogOfMovies) {
            normalOutputMovieInformation(movie);
        }
    }

    public static void normalOutputMovieInformation(Movie movie) {
        System.out.println("Movie title - " + movie.getTitle());
        System.out.println("Type of movie - " + movie.getPriceCode().getClass().getSimpleName());
        System.out.println("Director (-s) - " + movie.getDirector());
        System.out.println("Short info about movie - " + movie.getBriefDescription());
        System.out.print("genres - ");
        movie.getGenre().forEach(s -> System.out.print(s + ", "));
        System.out.print("\nactors - ");
        movie.getActors().forEach(s -> System.out.print(s + ", "));
        System.out.println("\n<-------------------------------------------->");
    }

    public static void takeAMovie(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Our catalog");
        outputCatalog();

        System.out.println("Enter title of movie");
        String inputTitle = scanner.nextLine();

        System.out.println("Input days");
        int days = scanner1.nextInt();

        for (Movie movie : CatalogOfMovies.catalogOfMovies) {
            if (movie.getTitle().equalsIgnoreCase(inputTitle)) {
                System.out.println("You have selected a movie: " + movie);
                customer.userFavoriteMovies.add(movie);
                Rental rental = new Rental(movie, days);
                double bonus = rental.getFrequentRenterPoints(days);
                System.out.println("You earned bonus: " + bonus);
                customer.setBonusPoints(customer.getBonusPoints()+ bonus);
                double amount = rental.getAmount();
                System.out.println("You need payed: " + amount);
                customer.setOwed(customer.getOwed() + amount);
            }
        }
        Menu.customerSerializer();
    }

    public static void outputUserFavoriteMovies(Customer customer) {
        for (Movie movie : customer.userFavoriteMovies) {
            normalOutputMovieInformation(movie);
        }
    }
}
