package ru.job4j.tracker.opp;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic str = new DummyDic();
        System.out.println(str.engToRus("dfdfff"));
    }
}
