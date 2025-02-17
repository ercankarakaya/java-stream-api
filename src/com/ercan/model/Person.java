package com.ercan.model;

import java.util.Objects;

public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name); // age == person.age
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Objects.hash(age);
    }


//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Person person = (Person) obj;
//        return age == person.age;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age);
//    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

}
