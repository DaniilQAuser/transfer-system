package com.example.transfer.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void shouldCreateValidMoney() {
        // Given (Дано)
        BigDecimal amount = new BigDecimal("100.50");
        String currency = "RUB";

        // When (Когда)
        Money money = new Money(amount, currency);

        // Then (Тогда)
        assertEquals(amount, money.getAmount(), "Сумма должна совпадать");
        assertEquals(currency, money.getCurrency(), "Валюта должна совпадать");
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNegative() {
        // Проверяем, что при отрицательной сумме вылетит исключение
        BigDecimal negativeAmount = new BigDecimal("-10");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Money(negativeAmount, "RUB")
        );

        assertEquals("Сумма не может быть отрицательной", exception.getMessage());
    }
}
