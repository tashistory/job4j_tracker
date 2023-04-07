package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftM  = left.split("\\.");
        String[] rightM = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftM[0]), Integer.parseInt(rightM[0]));
    }
}