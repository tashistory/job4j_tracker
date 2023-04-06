package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int k = 0;
        int lenght = Math.min(left.length(), right.length());
        if (left.length() != right.length()) {
            k = Integer.compare(left.length(), right.length());
        }
        for (int i = 0; i < lenght; i++) {
            k += Character.compare(left.charAt(i), right.charAt(i));
        }
        return k;
    }
}
