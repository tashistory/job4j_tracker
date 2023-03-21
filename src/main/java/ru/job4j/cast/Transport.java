package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle airline = new Airliner();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[]  transport = new Vehicle[]{airline, train, bus};
        for (Vehicle t : transport) {
            t.move();
            t.capacity();
            System.out.println();
        }
    }
}
