package patterns.task.CatalogClasses;

import patterns.task.Movie;
import patterns.task.MovieType;
import patterns.task.factorys.MovieFactory;

import java.util.List;
import java.util.Scanner;

public class SearchFilmInCatalog {
    public static void searchFilm() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("""
                            By what criteria do you want to search ?
                            1. Title                2. Category
                            3. Country Of Origin    4. Brief Description
                            5. Directors            6. Genre
                                           7. Actors
                            """);
        int choose = scanner.nextInt();
        List<Movie> catalog = CatalogOfMovies.catalogOfMovies;
        switch (choose) {
            case 1 -> {
                System.out.println("Input title");
                String inputName = scanner2.nextLine();
                for (Movie movie : catalog) {
                    if (movie.getTitle().equalsIgnoreCase(inputName)) {
                        System.out.println(movie);
                    }
                }
            }
            case 2 -> {
                System.out.println("Input category (1. Regular, 2. Children, 3. New Release)");
                String inputCategories = scanner2.nextLine();
                MovieType movieType = MovieFactory.createMovieType(inputCategories).createMovieType();
                for (Movie movie : catalog) {
                    if (movie.getPriceCode().equals(movieType)) {
                        System.out.println(movie);
                    }
                }
            }
            case 3 -> {
                System.out.println("Input country of origin");
                String inputCountryOfOrigin = scanner2.nextLine();
                for (Movie movie : catalog) {
                    if (movie.getCountryOfOrigin().equalsIgnoreCase(inputCountryOfOrigin)) {
                        System.out.println(movie);
                    }
                }
            }
            case 4 -> {
                System.out.println("Input Brief Description");
                String inputBriefDescription = scanner2.nextLine();
                for (Movie movie : catalog) {
                    if (movie.getBriefDescription().equalsIgnoreCase(inputBriefDescription)) {
                        System.out.println(movie);
                    }
                }
            }
            case 5 -> {
                System.out.println("Input Directors");
                String inputDirectors = scanner2.nextLine();
                for (Movie movie : catalog) {
                    if (movie.getDirector().contains(inputDirectors)) {
                        System.out.println(movie);
                    }
                }
            }
            case 6 -> {
                System.out.println("Input Genre");
                String inputGenre = scanner2.nextLine();
                for (Movie movie : catalog) {
                    if (movie.getGenre().contains(inputGenre)) {
                        System.out.println(movie);
                    }
                }
            }
            case 7 -> {
                System.out.println("Input Actors");
                String inputActors = scanner2.nextLine();
                for (Movie movie : catalog) {
                    if (movie.getActors().contains(inputActors)) {
                        System.out.println(movie);
                    }
                }
            }
            default -> System.out.println("You have entered an unavailable option");
        }

    }
}
