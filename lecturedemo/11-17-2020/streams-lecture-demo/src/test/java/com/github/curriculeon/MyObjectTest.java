package com.github.curriculeon;

import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyObjectTest {
    @Test
    public void compareFunctionToprediate() {
        Function<Double, Boolean> functionOfDoubleBoolean = number -> number > 0.5;
        Predicate<Double> predicateEquivalent = number -> number > 0.5;
    }

    @Test
    public void generateFilterLimitPrintMultiline() {
        Supplier<Double> rng = Math::random;
        Stream<Double> doubleStream = Stream.generate(rng);
        Predicate<Double> doublePredicate = number -> number > 0.5;
        Stream<Double> doubleStreamFiltered = doubleStream.filter(doublePredicate);
        Stream<Double> doubleStreamFilteredLimited = doubleStreamFiltered.limit(999);
        Consumer<Double> doubleConsumer = System.out::println;
        doubleStreamFilteredLimited.forEach(doubleConsumer);
    }

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
                    int randomVal = rng.nextInt(0, 100);
                    return randomVal;
                })
                .limit(150)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

}