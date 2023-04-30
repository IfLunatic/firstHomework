package patterns.task;

import java.io.Serializable;
import java.util.List;

import static patterns.task.CatalogClasses.CatalogOfMovies.catalogOfMovies;

public class Movie implements Serializable {
    private final String title;
    private final MovieType priceCode;
    private final String countryOfOrigin;
    private final String briefDescription;
    private final List<String> director;
    private final List<String> genre;
    private final List<String> actors;

    public Movie(String title, MovieType priceCode, String countryOfOrigin, String briefDescription, List<String> director, List<String> genre, List<String> actors) {
        this.title = title;
        this.priceCode = priceCode;
        this.countryOfOrigin = countryOfOrigin;
        this.briefDescription = briefDescription;
        this.director = director;
        this.genre = genre;
        this.actors = actors;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public List<String> getDirector() {
        return director;
    }

    public List<String> getGenre() {
        return genre;
    }

    public List<String> getActors() {
        return actors;
    }




    @Override
    public String toString() {
        return "Movie " +
                "title='" + title + '\'' +
                ", priceCode=" + priceCode +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", briefDescription='" + briefDescription + '\'' +
                ", director=" + director +
                ", genre=" + genre +
                ", actors=" + actors +
                ' ';
    }
}