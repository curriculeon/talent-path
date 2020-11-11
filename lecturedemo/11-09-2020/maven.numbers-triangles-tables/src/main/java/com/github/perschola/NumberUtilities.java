package com.github.perschola;


public class NumberUtilities {
    public static String getEvenNumbers(int start, int stop) {
        return getRange(start % 2 == 0 ? start : start + 1, stop, 2);
    }


    public static String getOddNumbers(int start, int stop) {
        return getRange(start % 2 == 1 ? start : start + 1, stop, 2);
    }


    public static String getSquareNumbers(int start, int stop, int step) {
        return getExponentiations(start, stop, step, 2);
    }

    public static String getRange(int stop) {
        return getRange(0, stop);
    }

    public static String getRange(int start, int stop) {
        return getRange(start, stop, 1);
    }


    public static String getRange(int start, int stop, int step) {
        return getExponentiations(start, stop, step, 1);
    }


    public static String getExponentiations(int start, int stop, int step, int exponent) {
        String result = "";
        for (int i = start; i < stop; i+=step) {
            Double resultAsDouble = Math.pow(i, exponent);
            Integer resultAsInteger = resultAsDouble.intValue();
            result += resultAsInteger;
        }
        return result;
    }
}
