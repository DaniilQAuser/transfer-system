package org.example;

import com.example.transfer.domain.Money;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Создаем правильные деньги
        Money myMoney = new Money(new BigDecimal("150.50"), "RUB");
        System.out.println("Успешно создан объект: " + myMoney);

        // А теперь попробуем создать неправильные (отрицательные)
        try {
            Money badMoney = new Money(new BigDecimal("-10"), "RUB");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации перехвачена: " + e.getMessage());
        }
    }
}