package org.example;

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
    }
    public static int sum(int x, int y) {
        return x + y;
    }
}
