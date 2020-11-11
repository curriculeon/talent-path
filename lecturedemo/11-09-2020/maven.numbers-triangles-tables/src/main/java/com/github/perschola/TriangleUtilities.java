package com.github.perschola;

public class TriangleUtilities {

    public static String getRow(int numberOfStars) {
        return new String(new char[numberOfStars]).replaceAll("\u0000", "*");
    }

    public static String getTriangle(int numberOfRows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numberOfRows; i++) {
            sb.append(getRow(i) + "\n");
        }
        return sb.toString();
    }

    public static String getSmallTriangle() {
        return getTriangle(5);
    }

    public static String getLargeTriangle() {
        return getTriangle(10);
    }
}
