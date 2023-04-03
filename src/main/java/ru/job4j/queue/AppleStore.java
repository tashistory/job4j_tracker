package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int k = 0;
        for (Customer c : queue) {
            k++;
            if (k == count) {
                return c.name();
            }
        }
        return "";
    }

    public String getFirstUpsetCustomer() {
        int k = 0;
        for (Customer c : queue) {
            k++;
            if (k == count + 1) {
                return c.name();
            }
        }
        return "";
    }
}