package model;

public class Payment {
    private String id;
    private double amount;
    private PaymentStatus status;
    private PaymentMethod method;

    public Payment(String id, double amount, PaymentStatus status, PaymentMethod method) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}