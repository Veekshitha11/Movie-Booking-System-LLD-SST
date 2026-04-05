package controller;

import service.*;
import model.*;

public class AdminController {
    private MovieService movieService;
    private TheaterService theaterService;
    private ShowService showService;

    public AdminController(MovieService m, TheaterService t, ShowService s) {
        this.movieService = m;
        this.theaterService = t;
        this.showService = s;
    }

    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
    }

    public void addTheater(Theater theater) {
        theaterService.addTheater(theater);
    }

    public void addShow(Show show) {
        showService.addShow(show);
        show.getTheater().addShow(show);
    }
}