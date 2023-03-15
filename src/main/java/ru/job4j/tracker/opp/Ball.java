package ru.job4j.tracker.opp;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Съеден");
        } else {
            System.out.println("Сбежал");
        }
    }
}
