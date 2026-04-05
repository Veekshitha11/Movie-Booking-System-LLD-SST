package service;

import model.Movie;
import java.util.*;

public class MovieService {
    private Map<String, Movie> movies = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public Collection<Movie> getAllMovies() {
        return movies.values();
    }
}