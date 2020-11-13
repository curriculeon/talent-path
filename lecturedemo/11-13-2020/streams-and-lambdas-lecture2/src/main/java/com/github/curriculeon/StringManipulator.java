package com.github.curriculeon;

import java.util.List;

public class StringManipulator {
    private String stringToBeManipulated;

    public StringManipulator(String stringToBeManipulated) {
        this.stringToBeManipulated = stringToBeManipulated;
    }

    public List<String> getAllSubStrings() {
        Double multiplier = Math.pow(26, stringToBeManipulated.length());
        try {
            Thread.sleep(1000 * multiplier.longValue());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String reverseWithStringBuilder() {
        return new StringBuilder(stringToBeManipulated)
                .reverse()
                .toString();
    }

    public String reverseWithoutStringBuilder() {
        String result = "";
        for (int i = stringToBeManipulated.length() - 1; i >= 0; i--) {
            Character nextCharacter = stringToBeManipulated.charAt(i);
            result += nextCharacter.toString();
        }
        return result;
    }


}
