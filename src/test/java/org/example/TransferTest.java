package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TransferTest {

    @Test
    void shouldCreateValidTransfer() {
        // Given: создаем объект с нормальными данными
        Transfer transfer = new Transfer("TX-1", 1000.0, "NEW");

        // Then: проверяем через AssertJ
        assertThat(transfer.getId()).isEqualTo("TX-1");
        assertThat(transfer.getAmount()).isEqualTo(1000.0);
        assertThat(transfer.getStatus()).isEqualTo("NEW");
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNegative() {
        assertThatThrownBy(() -> new Transfer("TX-2", -10, "NEW"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма перевода не может быть отрицательной!");
        // Твой код здесь.
        // Вызови assertThatThrownBy, внутри лямбды попробуй создать Transfer с суммой -10.
        // Проверь, что исключение - это IllegalArgumentException,
        // И что текст ошибки: "Сумма перевода не может быть отрицательной!"
    }



}
