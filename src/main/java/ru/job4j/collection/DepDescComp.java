package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    public int compare(String left, String right) {
        String[] leftM = left.split("/");
        String[] rightM = right.split("/");
        int rslt = rightM[0].compareTo(leftM[0]);
        return rslt == 0 ? left.compareTo(right) : rslt;
    }
}
