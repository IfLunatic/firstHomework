package patterns.task.factorys;


import patterns.task.MovieType;
import patterns.task.Regular;

public class RegularFactory implements MovieTypeFactory {
    @Override
    public MovieType createMovieType() {
        return new Regular();
    }
}
