package org.example;

import java.util.ArrayList;
import java.util.List;

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

        Transfer myTransfer = new Transfer();
        myTransfer.id = "TX-1001";
        myTransfer.amount = 5000.50;
        myTransfer.status = "NEW";

        System.out.println(myTransfer.amount + " " + myTransfer.status);

        Transfer myTransfer2 = new Transfer();
        myTransfer2.id = "TX-1002";
        myTransfer2.amount = 2342.50;
        myTransfer2.status = "DONE";

        System.out.println(myTransfer2.amount + " " + myTransfer2.status);

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(myTransfer);
        transfers.add(myTransfer2);
        for (Transfer t : transfers) {
            System.out.println("Перевод: " + t.id + " на сумму " + t.amount);
        }
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
