package ru.job4j.tracker.opp;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public double divide(int a) {
        return a / x;
    }

   public double sumAllOperation(int a) {
       return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        System.out.println(minus(4));
        System.out.println(calculator.divide(2));
        System.out.println(calculator.sumAllOperation(3));
    }
}
