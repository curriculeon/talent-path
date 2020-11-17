package com.github.curriculeon;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {
    @Test
    public void testLetters() {
        letters("hypothetical").forEach(System.out::println);
    }


    public Stream<String> letters(String someWord) {
        String[] characters = someWord.split("");
        return Stream.of(characters);
    }

    public Stream<String> wordsFlatMap(String[] stringArray) {
        return Arrays.stream(stringArray).flatMap(this::letters);
    }

    @Test
    public void testWordsFlatMap() {
        wordsFlatMap("The quickest of brown foxeries".split(" "))
                .forEach(System.out::println);
    }


    public Stream<Stream<String>> wordsMap(String[] stringArray) {
        return Arrays.stream(stringArray).map(this::letters);
    }

    @Test
    public void testWordsMap() {
        wordsMap("The quickest of brown foxeries".split(" "))
                .forEach(stringStream -> stringStream
                        .forEach(System.out::println));
    }
}