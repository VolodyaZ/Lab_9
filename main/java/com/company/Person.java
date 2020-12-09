package com.company;

import java.util.Objects;

public class Person {
    private String gender;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    public Person(String gender, String firstName, String lastName, int age, String country) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public Person() {
        this("", "", "", 0, "");
    }

    public Person(Person other) {
        this.gender = other.gender;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.country = other.country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(country, person.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, firstName, lastName, age, country);
    }
}
