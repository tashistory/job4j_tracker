package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() +  " едет по рельсам");
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость 810 человек");
    }
}
