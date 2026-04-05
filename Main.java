import service.*;
import controller.*;
import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        MovieService movieService = new MovieService();
        TheaterService theaterService = new TheaterService();
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();

        AdminController admin = new AdminController(movieService, theaterService, showService);
        CustomerController customer = new CustomerController(movieService, theaterService, showService, bookingService);

        Movie movie = new Movie("1", "Inception", 150);
        Theater theater = new Theater("1", "PVR", "Bangalore");

        admin.addMovie(movie);
        admin.addTheater(theater);

        Show show = new Show("1", movie, theater, 10);
        admin.addShow(show);

        customer.viewMovies();
        customer.viewSeats("1");

        customer.book("1", Arrays.asList(1,2,3));

        customer.viewSeats("1");
    }
}