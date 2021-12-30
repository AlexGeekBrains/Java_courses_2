package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, ArrayList> telephoneDirectory = new HashMap<>();

    public void add(String surname, String telephone) {
        if (telephoneDirectory.containsKey(surname)) {
            ArrayList<String> phone = telephoneDirectory.get(surname);
            phone.add(telephone);
        } else {
            ArrayList<String> phone = new ArrayList<>();
            phone.add(telephone);
            telephoneDirectory.put(surname, phone);
        }
    }

    public ArrayList get(String surname) {
        return telephoneDirectory.get(surname);
    }

    @Override
    public String toString() {
        return String.valueOf(telephoneDirectory);
    }
}
