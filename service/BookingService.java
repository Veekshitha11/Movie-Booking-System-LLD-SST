package service;

import model.*;
import java.util.*;

public class BookingService {

    private PaymentService paymentService = new PaymentService();
    private static final double PRICE = 200;

    public Booking bookSeats(Show show, List<Integer> seats, PaymentMethod method) {

        Booking booking = new Booking(UUID.randomUUID().toString(), show, seats);
        List<Seat> lockedSeats = new ArrayList<>();

        // 🔒 STEP 1: HOLD SEATS
        for (int seatNo : seats) {
            Seat seat = show.getSeats().get(seatNo);

            synchronized (seat) {
                if (seat == null || !seat.hold()) {
                    rollback(lockedSeats);
                    booking.fail();
                    throw new RuntimeException("Seat unavailable");
                }
                lockedSeats.add(seat);
            }
        }

        // 💳 STEP 2: PAYMENT WITH RETRY
        double amount = seats.size() * PRICE;

        Payment payment = paymentService.processPayment(amount, method);

        if (payment.getStatus() != PaymentStatus.SUCCESS) {
            System.out.println("Retrying payment...");
            payment = paymentService.processPayment(amount, method);
        }

        // ❌ STEP 3: FAILURE
        if (payment.getStatus() != PaymentStatus.SUCCESS) {
            rollback(lockedSeats);
            booking.fail();
            throw new RuntimeException("Payment failed");
        }

        // ✅ STEP 4: CONFIRM
        for (Seat seat : lockedSeats) {
            seat.confirm();
        }

        booking.confirm();
        return booking;
    }

    private void rollback(List<Seat> seats) {
        for (Seat seat : seats) {
            seat.unbook();
        }
    }
}