package org.example;

public class Transfer {
    private String id;
    private double amount;
    private String status;

    public Transfer(String id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;

        if (amount < 0) {
            throw new IllegalArgumentException("Сумма перевода не может быть отрицательной!");
        }
    }
    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
