package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> conPhone = person -> person.getPhone().contains(key);
        Predicate<Person> conName = person -> person.getName().contains(key);
        Predicate<Person> conSurname = person -> person.getPhone().contains(key);
        Predicate<Person> conAdress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = conAdress.or(conPhone).or(conName).or(conSurname);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}