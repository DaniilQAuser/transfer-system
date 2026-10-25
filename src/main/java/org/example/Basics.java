package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Basics {
    public static void main(String[] args) {

        int age = 13;

        String name = "Daniil";

        double height = 1.76;

        boolean isQa = true;

        System.out.println(age);
        System.out.println(name);
        System.out.println(height);
        System.out.println(isQa);

        double a = 0.1;
        double b = 0.2;
        System.out.println(a + b);

        int result = sum(5, 7);
        System.out.println("Сумма: " + result);

        checkMoney(1500, 500);
        checkMoney(1000, 5000);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Перевод номер: " + i + " Успешен");
        }

        Transfer myTransfer = new Transfer("TX-1001", 5000.50, "NEW");


        Transfer myTransfer2 = new Transfer("TX-1002", 2342.50, "DONE");

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(myTransfer);
        transfers.add(myTransfer2);
        for (Transfer t : transfers) {
            System.out.println("Перевод: " + t.getId() + " на сумму " + t.getAmount());
        }
        // Создаем список, который хранит в себе ЛЮБЫЕ реализации интерфейса NotificationService
        List<NotificationService> services = new ArrayList<>();
        services.add(new EmailNotification());
        services.add(new SmsNotification());

// Проходимся циклом и вызываем метод send()
        for (NotificationService service : services) {
            service.send("Ваш перевод одобрен!");
        }

        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("TX-1001", "NEW");
        statusMap.put("TX-1002", "DONE");

        String status = statusMap.get("TX-1001");
        System.out.println("Статус перевода TX-1001: " + status);

        System.out.println("Есть ли TX-9999? " + statusMap.containsKey("TX-9999"));

        System.out.println("--- Начало опасной операции ---");

        try {
            int divf = 10;
            int divc = 0;
            int divResult = divf / divc; // На ноль делить нельзя! Здесь будет ошибка.
            System.out.println("Результат: " + divResult); // Эта строка не выполнится

        } catch (ArithmeticException e) {
            System.out.println("Ошибка перехвачена! Причина: " + e.getMessage());
        }

        System.out.println("--- Программа продолжает работу ---");
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static void checkMoney(double balance, double price) {
        if (balance >= price) {
            System.out.println("Покупка одобрена");
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
