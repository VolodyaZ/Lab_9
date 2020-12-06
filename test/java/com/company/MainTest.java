package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void countMales() {
        List<Person> list = Arrays.asList(
                new Person("male", "Daniel", "Moore", 54, "New Zealand"),
                new Person("female", "Kelly", "Cole", 54, "Ireland"),
                new Person("male", "Ron", "Henry", 48, "Australia"),
                new Person("female", "Nora", "Graves", 41, "France")
        );
        int expected = 2;
        assertEquals(expected, Main.countMales(list));
    }

    @org.junit.jupiter.api.Test
    void createMap() {
        List<Person> list = Arrays.asList(
                new Person("male", "Daniel", "Moore", 54, "New Zealand"),
                new Person("female", "Kelly", "Cole", 54, "Ireland"),
                new Person("male", "Ron", "Henry", 48, "Australia"),
                new Person("female", "Nora", "Graves", 41, "France")
        );
        Map<String, Person> expected = new HashMap<>();
        expected.put(list.get(0).getLastName(), list.get(0));
        expected.put(list.get(1).getLastName(), list.get(1));
        expected.put(list.get(2).getLastName(), list.get(2));
        expected.put(list.get(3).getLastName(), list.get(3));

        assertEquals(expected, Main.createMap(list));
    }

    @org.junit.jupiter.api.Test
    void averageAge() {
        List<Person> list = Arrays.asList(
                new Person("male", "Daniel", "Moore", 54, "New Zealand"),
                new Person("female", "Kelly", "Cole", 54, "Ireland"),
                new Person("male", "Ron", "Henry", 48, "Australia"),
                new Person("female", "Nora", "Graves", 41, "France")
        );
        double expected = 49.25;
        assertEquals(expected, Main.averageAge(list));
    }

    @org.junit.jupiter.api.Test
    void allFirstNamesStartWithVowels() {
        List<Person> list = Arrays.asList(
                new Person("male", "Oleg", "Moore", 54, "New Zealand"),
                new Person("female", "Oona", "Cole", 54, "Ireland"),
                new Person("male", "Alexandr", "Henry", 48, "Australia"),
                new Person("female", "Anna", "Graves", 41, "France")
        );
        boolean expected = true;
        assertEquals(expected, Main.allFirstNamesStartWithVowels(list));
    }

    @org.junit.jupiter.api.Test
    void groupByCountry() {
        Person p1 = new Person("male", "Oleg", "Moore", 54, "France");
        Person p2 = new Person("female", "Oona", "Cole", 54, "Ireland");
        Person p3 = new Person("male", "Alexandr", "Henry", 48, "France");
        Person p4 = new Person("female", "Anna", "Graves", 41, "France");
        Person p5 = new Person("male", "Lauri", "Laitinen", 72, "Finland");
        Person p6 = new Person("female", "Camille", "Martin", 52, "Ireland");
        List<Person> list = Arrays.asList(p1, p2, p3, p4, p5, p6);
        Map<String, List<Person>> expected = new HashMap<>();
        expected.put("France", Arrays.asList(p1, p3, p4));
        expected.put("Ireland", Arrays.asList(p2, p6));
        expected.put("Finland", Arrays.asList(p5));
        assertEquals(expected, Main.groupByCountry(list));
    }
}