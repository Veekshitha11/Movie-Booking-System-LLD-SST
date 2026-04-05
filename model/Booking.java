package model;

import java.util.*;

public class Booking {
    private String id;
    private Show show;
    private List<Integer> seatNumbers;
    private BookingStatus status;

    public Booking(String id, Show show, List<Integer> seats) {
        this.id = id;
        this.show = show;
        this.seatNumbers = seats;
        this.status = BookingStatus.PENDING;
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void fail() {
        this.status = BookingStatus.FAILED;
    }

    public String getId() { return id; }
}