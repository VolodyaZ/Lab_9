package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String VOWELS = "aAeEiIoOuUyY";

    public static void main(String[] args) {
        int n = 0;
        System.out.println("enter size of Persons list:(might generate less) ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
        } catch (Exception ignored) { }
        List<Person> list = PersonGenerator.generate(n);
        list.forEach(System.out::println);
        System.out.println("Amount of people: " + list.size());
        System.out.println(countMales(list));
        System.out.println(createMap(list));
        System.out.println(averageAge(list));
        System.out.println(allFirstNamesStartWithVowels(list));
        System.out.println(groupByCountry(list));
    }

     public static int countMales(List<Person> list) {
        return (int)list.stream()
                .map(a -> a.getGender().equals("male") ? 1 : 2)
                .filter(a -> a == 1)
                .count();
     }

    /**
     * create map where key is the last name of a person
     * @param list
     * @return
     */
     public static Map<String, Person> createMap(List<Person> list) {
         return list.stream().collect(Collectors.toMap(Person::getLastName, Person::new,
                 (existing, replacement) -> existing));
     }

     public static double averageAge(List<Person> list) {
         Optional<Double> opt = list.stream().map(person -> (double)person.getAge() / list.size()).reduce(Double::sum);
         return opt.orElse(0.);
     }

     public static boolean allFirstNamesStartWithVowels(List<Person> list) {
         return list.stream().allMatch(p -> VOWELS.matches(".*" + p.getFirstName().charAt(0) + ".*"));
     }

     public static Map<String, List<Person>> groupByCountry(List<Person> list) {
         return list.stream().collect(Collectors.groupingBy(Person::getCountry));
    }
}
