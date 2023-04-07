package ru.job4j.collection;

import java.util.Comparator;
import java.util.SortedMap;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lenght = Math.min(left.length(), right.length());
        for (int i = 0; i < lenght; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return  Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
