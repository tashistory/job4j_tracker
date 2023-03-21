package ru.job4j.cast;

public class Airliner implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает");
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость 250 пасажиров");
    }
}
