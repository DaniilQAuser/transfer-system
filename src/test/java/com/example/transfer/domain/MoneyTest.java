package com.example.transfer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.math.BigDecimal;

// Мы больше не используем статические методы из Assertions.*
// Мы используем статический импорт из AssertJ
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void shouldCreateValidMoney() {
        BigDecimal amount = new BigDecimal("100.50");
        String currency = "RUB";

        Money money = new Money(amount, currency);

        // AssertJ стиль: читается как обычный английский текст
        assertThat(money.getAmount()).isEqualByComparingTo("100.50");
        assertThat(money.getCurrency()).isEqualTo("RUB");
    }

    // Параметризованный тест: проверяет сразу несколько невалидных сумм
    @ParameterizedTest(name = "Сумма {0} должна вызывать ошибку")
    @ValueSource(strings = {"-10", "-0.01", "-100500"})
    void shouldThrowExceptionWhenAmountIsNegative(String negativeAmount) {

        assertThatThrownBy(() -> new Money(new BigDecimal(negativeAmount), "RUB"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма не может быть отрицательной");
    }

    @Test
    void shouldThrowExceptionWhenCurrencyIsNull() {
        assertThatThrownBy(() -> new Money(new BigDecimal("100"), null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма и валюта не могут быть пустыми");
    }
}
