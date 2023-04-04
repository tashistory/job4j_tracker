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
        for (int i = 0; i < queue.size(); i++) {
            if (i == count - 1) {
                return queue.peek().name();
            }
           queue.poll();
        }
        return "";
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < queue.size(); i++) {
            queue.poll();
            if (i == count - 1) {
                return queue.peek().name();
            }
        }
        return "";
    }
}