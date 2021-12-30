package ru.geekbrains.lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] arr = new String[20];

        for (int i = 0; i < arr.length; i++) {
            if (i < 6) {
                arr[i] = "cat";
            } else if (i < 15) {
                arr[i] = "dog";
            } else {
                arr[i] = "horse";
            }
        }

        Map<String, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int countValue = mapCount.getOrDefault(arr[i], 0);
            mapCount.put(arr[i], countValue + 1);
        }

        System.out.println(mapCount);

        ru.geekbrains.lesson3.PhoneBook phoneBook;
        phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "89163278575");
        phoneBook.add("Rustavili", "89163278574");
        phoneBook.add("Danko", "8916345555");
        phoneBook.add("Ivanov", "89163278574");
        phoneBook.add("Zheglov", "89163278577");
        phoneBook.add("Ivanov", "89163278576");
        phoneBook.add("Rustavili", "89163278511");

        System.out.println(phoneBook);

        System.out.println(phoneBook.get("Ivanov"));
    }
}
