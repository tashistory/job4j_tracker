package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("vasiliy@gmail.com", "Vasisliy Petrov");
        map.put("vasiliy@gmail.com", "Василий Петров");
        map.put("dmitriy@mail.ru", "Дмитрий Кузнецов");
        map.put("dmitriy@mail.ru", "Dmitriy Kuznetsov");
        map.put("antoliy@yandex.ru", "Anantoliy Volkov");
        map.put("antoliy@yandex.ru", "Анатолий Волков");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(String.format("%-20s %-20s", key, value));
        }
    }
}
