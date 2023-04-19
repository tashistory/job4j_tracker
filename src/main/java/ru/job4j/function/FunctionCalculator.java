package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        ArrayList<Double> reslt  = new ArrayList<>();
        for (double i = start; i < end; i++) {
          reslt.add(func.apply(i));
        }
        return reslt;
    }
}