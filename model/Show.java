package model;

import java.util.*;

public class Show {
    private String id;
    private Movie movie;
    private Theater theater;
    private Map<Integer, Seat> seats = new HashMap<>();

    public Show(String id, Movie movie, Theater theater, int totalSeats) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;

        for (int i = 1; i <= totalSeats; i++) {
            seats.put(i, new Seat(i));
        }
    }

    public Map<Integer, Seat> getSeats() {
        return seats;
    }

    public String getId() { return id; }

     public Theater getTheater() {
        return theater;
    }
}