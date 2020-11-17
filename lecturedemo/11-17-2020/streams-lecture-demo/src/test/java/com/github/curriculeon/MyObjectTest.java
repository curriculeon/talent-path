package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyObjectTest {
    @Test
    public void generateFilterLimitPrint() {
        Stream
                .generate(Math::random)
                .filter(number -> number > 0.5)
                .limit(999)
                .forEach(System.out::println);
    }

    @Test
    public void testCount() {
        String[] anagram = "The quick brown fox".split(" ");

        Long numberOfWordsGreaterThan3 = Arrays
                .stream(anagram)
                .filter(word -> word.length() > 3)
                .count();
    }

    @Test
    public void testMapStringToPerson() {
        String[] anagram = "The quick brown fox".split(" ");
        Stream<Person> personStream = Arrays
                .stream(anagram)
                .map(word -> new Person(word));
    }

    @Test
    public void testMapDoubleToPerson() {
        Stream
                .generate(Math::random)
                .map(randomNumber -> new Person(randomNumber))
                .forEach(person -> System.out.println(person.toString()));
    }

    @Test
    public void testMapUUIDToPerson() {
        Stream
                .generate(UUID::randomUUID)
                .map(uuid -> new Person(uuid.toString()))
                .forEach(person -> System.out.println(person.toString()));
    }


    @Test
    public void testGenerateRandomNumbersAndFilterAndDistinctAndPrint() {
        Stream
                .generate(() -> {
                    ThreadLocalRandom rng = ThreadLocalRandom.current();
                    int randomVal = rng.nextInt(0,100);
                    return randomVal;
                })
                .limit(150)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

}