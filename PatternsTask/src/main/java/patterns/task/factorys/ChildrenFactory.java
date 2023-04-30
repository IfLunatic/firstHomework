package patterns.task.factorys;

import patterns.task.Children;
import patterns.task.MovieType;

public class ChildrenFactory implements MovieTypeFactory{
    @Override
    public MovieType createMovieType() {
        return new Children();
    }
}
