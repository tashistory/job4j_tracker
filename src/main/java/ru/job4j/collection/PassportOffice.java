package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        for (Map.Entry<String, Citizen> citizen : citizens.entrySet()) {
            if (citizen.getKey().equals(passport)) {
                return new Citizen(citizen.getKey(), citizen.getValue().getUsername());
            }
        }
        return null;
    }
}