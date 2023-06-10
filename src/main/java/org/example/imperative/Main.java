package org.example.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.example.imperative.Main.Gender.FEMALE;
import static org.example.imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println("\n<<Imperative approach>>");
        // Imperative approach
        List<Person> female = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                female.add(person);
            }
        }

        for (Person person : female) {
            System.out.println(person);
        }

        System.out.println("\n<<Declarative approach>>");
        // Declarative approach
        final Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);

        System.out.println("\n<<Declarative approach [Solution 2]>>");
        // Declarative approach
        final List<Person> female2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        female2.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}