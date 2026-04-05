package model;

public class Seat {
    private int seatNumber;
    private boolean isBooked;
    private long holdTime; // timestamp

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.holdTime = 0;
    }

    public synchronized boolean hold() {
        if (isBooked) return false;

        long now = System.currentTimeMillis();

        // expire hold after 5 seconds
        if (holdTime != 0 && (now - holdTime) < 5000) {
            return false;
        }

        holdTime = now;
        return true;
    }

    public synchronized void confirm() {
        isBooked = true;
        holdTime = 0;
    }

    public synchronized void unbook() {
        isBooked = false;
        holdTime = 0;
    }

    public boolean isBooked() { return isBooked; }
}