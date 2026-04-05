package service;

import model.*;
import java.util.*;

public class PaymentService {

    public Payment processPayment(double amount, PaymentMethod method) {
        boolean success = simulate(method);

        if (success) {
            System.out.println("Payment SUCCESS via " + method);
            return new Payment(UUID.randomUUID().toString(), amount, PaymentStatus.SUCCESS, method);
        } else {
            System.out.println("Payment FAILED via " + method);
            return new Payment(UUID.randomUUID().toString(), amount, PaymentStatus.FAILED, method);
        }
    }

    private boolean simulate(PaymentMethod method) {
        Random rand = new Random();

        // different success rates
        switch (method) {
            case UPI: return rand.nextInt(100) < 80;
            case CARD: return rand.nextInt(100) < 70;
            case WALLET: return rand.nextInt(100) < 90;
        }
        return false;
    }
}