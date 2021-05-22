import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MovieStoreTest {

    private final MovieStore movieStore = new MovieStore();
    private final Movie harryPotter = new Movie("Harry Potter", "Rowling",2000);
    private final Movie star_trek = new Movie("STAR Trek","Shwimmer", 1999);
    private final Movie star_wars = new Movie("Star Wars", "Shwimmer", 2002);
    private final Movie shawshank = new Movie("Shawshank Redemption", "Bob", 2001);
    private final Movie takeThat = new Movie("Take That", "Shwimmer", 2010);

    @Before
    public void setUp() throws Exception {
        movieStore.add(shawshank);
        movieStore.add(harryPotter);
        movieStore.add(star_wars);
        movieStore.add(star_trek);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abc");
        assertEquals(results.size(), 0);
    }

    @Test
    public void findsAMoviesWhenTitlesArePartiallyMatchedCaseInsensitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("tar");
        assertEquals(results.size(), 2);
        assertEquals(results.contains(star_trek), true);
        assertEquals(results.contains(star_wars), true);
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Shwimmer");
        assertEquals(results.size(), 3);
        assertEquals(results.contains(star_trek), true);
        assertEquals(results.contains(star_wars), true);
        assertEquals(results.contains(takeThat), true);
    }

    @Test
    public void findsMoviesWhenReleaseYearIsBetweenTwoValues() throws Exception {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);
        assertEquals(results.size(), 2);
        assertEquals(results.contains(harryPotter), true);
        assertEquals(results.contains(shawshank), true);
    }
}