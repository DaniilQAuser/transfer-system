package com.example.transfer.domain;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        // Защита от дурака: деньги не могут быть null или отрицательными
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Сумма и валюта не могут быть пустыми");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    // Этот метод нужен, чтобы при выводе на экран мы видели "100.50 RUB", а не непонятный набор букв
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
