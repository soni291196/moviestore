package model;

public class Movie {
    private String title;
    private String director;
    private int releaseYear;

    public Movie(String movie, String director, int releaseYear) {
        this.title = movie;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String title() {
        return title;
    }

    public String director() {
        return director;
    }

    public int releaseYear() {
        return releaseYear;
    }
}
