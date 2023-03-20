package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Еду");
    }

    @Override
    public void numberOfPass(int pass) {
        System.out.println(String.format("Зашли d%", pass));
    }

    @Override
    public double refuel(double fuel) {
        double price = 66.7;
        return fuel * price;
    }
}
