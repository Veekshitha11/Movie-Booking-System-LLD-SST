package controller;

import service.*;
import model.*;
import java.util.*;

public class CustomerController {
    private MovieService movieService;
    private TheaterService theaterService;
    private ShowService showService;
    private BookingService bookingService;

    public CustomerController(MovieService m, TheaterService t, ShowService s, BookingService b) {
        this.movieService = m;
        this.theaterService = t;
        this.showService = s;
        this.bookingService = b;
    }

    public void viewMovies() {
        movieService.getAllMovies().forEach(m -> 
            System.out.println(m.getName()));
    }

    public void viewSeats(String showId) {
        Show show = showService.getShow(showId);
        show.getSeats().forEach((k, v) ->
            System.out.println("Seat " + k + ": " + v.isBooked()));
    }

   public void book(String showId, List<Integer> seats) {
    Show show = showService.getShow(showId);

    Booking booking = bookingService.bookSeats(
        show,
        seats,
        PaymentMethod.UPI
    );

    System.out.println("Booking Confirmed: " + booking.getId());
}
}