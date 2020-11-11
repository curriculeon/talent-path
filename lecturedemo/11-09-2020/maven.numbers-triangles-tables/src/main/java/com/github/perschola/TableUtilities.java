package com.github.perschola;

public class TableUtilities {
    public static String getSmallMultiplicationTable() {
        return getMultiplicationTable(5);
    }

    public static String getLargeMultiplicationTable() {
        return getMultiplicationTable(10);
    }

    public static String getMultiplicationTable(int tableSize) {
        String result = "";
        for (int column = 1; column <= tableSize; column++) {
            for (int row = 1; row <= tableSize; row++) {
                int product = column * row;
                result += String.format("%3d |", product);
            }
            result += "\n";
        }
        return result;
    }
}