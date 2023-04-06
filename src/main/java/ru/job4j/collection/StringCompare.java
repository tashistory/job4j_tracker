package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int k = 0;
        int leght = left.length();
        if (left.length() > right.length()) {
          k = 1;
          leght = right.length();
        } else if (left.length() < right.length()) {
             k = -1;
        }
        for (int i = 0; i < leght; i++) {
            k += Character.compare(left.charAt(i), right.charAt(i));
        }
        System.out.println(k);
        return k;
    }
}
