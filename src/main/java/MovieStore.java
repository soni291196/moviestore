import model.Movie;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {
    List<Movie> movies = new LinkedList<>();

    interface Predicate{
        boolean matches(Movie movie);
    }

    private List<Movie> findBy(Predicate predicate) {
        List<Movie> output = new LinkedList<>();
        for (Movie movie : movies) {
            if (predicate.matches(movie)) {
                output.add(movie);
            }
        }
        return output;
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByPartialTitle(final String partialTitle) {
        return findBy(movie -> movie.title().toUpperCase().contains(partialTitle.toUpperCase()));
    }

    public List<Movie> findByDirector(final String director) {
        return findBy(movie -> movie.director().toUpperCase().contains(director.toUpperCase()));
    }

    public List<Movie> findByReleaseYear(final int from,final int to) {
        return findBy(movie -> movie.releaseYear() > from && movie.releaseYear() < to);
    }
}
