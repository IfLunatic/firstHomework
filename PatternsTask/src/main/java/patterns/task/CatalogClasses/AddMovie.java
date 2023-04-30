package patterns.task.CatalogClasses;

import patterns.task.Movie;
import patterns.task.MovieType;
import patterns.task.factorys.MovieFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddMovie {

    public static void addMovie () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of film");
        String inputNameOfFilm = scanner.nextLine();

        System.out.println("Enter Regular or New Release or Children");
        String inputCategoryOfFilms = scanner.nextLine();

        System.out.println("Enter country of origin");
        String inputOriginOfFilm = scanner.nextLine();

        System.out.println("Enter brief description");
        String inputBriefDescription = scanner.nextLine();

        System.out.println("Enter directors with comas");
        List<String> inputDirectorsOfFilm = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        System.out.println("Enter genre with comas");
        List<String> inputGenreOfFilm = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        System.out.println("Enter actors with comas");
        List<String> inputActorsOfFilm = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        MovieType inputCategories = MovieFactory.createMovieType(inputCategoryOfFilms).createMovieType();

        Movie movie = new Movie(inputNameOfFilm, inputCategories, inputOriginOfFilm, inputBriefDescription ,inputDirectorsOfFilm, inputGenreOfFilm, inputActorsOfFilm);
        CatalogOfMovies.catalogOfMovies.add(movie);
        CatalogOfMovies.movieSerializer();
    }
}
