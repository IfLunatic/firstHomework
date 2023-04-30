package patterns.task.factorys;

import java.util.HashMap;

public class MovieFactory {

    private static final HashMap<String, MovieTypeFactory> cache = new HashMap<>();

    public static MovieTypeFactory createMovieType(String typeOfFilm) {
        MovieTypeFactory movieTypeFactory = cache.get(typeOfFilm);
        if (movieTypeFactory == null) {
            if (typeOfFilm.equalsIgnoreCase("regular")) {
                movieTypeFactory = new RegularFactory();
            } else if (typeOfFilm.equalsIgnoreCase("new release")) {
                movieTypeFactory = new NewReleaseFactory();
            } else if (typeOfFilm.equalsIgnoreCase("children")) {
                movieTypeFactory = new ChildrenFactory();
            } else {
                throw new RuntimeException(typeOfFilm + " is unknown specialty");
            }
            cache.put(typeOfFilm, movieTypeFactory);
        }
        return movieTypeFactory;
    }
}
