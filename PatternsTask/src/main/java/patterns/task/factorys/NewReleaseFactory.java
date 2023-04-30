package patterns.task.factorys;

import patterns.task.MovieType;
import patterns.task.NewRelease;

public class NewReleaseFactory implements MovieTypeFactory{
    @Override
    public MovieType createMovieType() {
        return new NewRelease();
    }
}
