package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;

public class Dice implements  Iterable<Die> {
    private final Die[] dieArray;

    /**
     * @param numberOfDie - number of die-objects to be contained
     */
    public Dice(Integer numberOfDie) {
        this(numberOfDie, 6);
    }

    /**
     * @param numberOfDie - number of die-objects to be contained
     * @param numberOfFaces - number of faces on a single die-object
     */
    public Dice(Integer numberOfDie, Integer numberOfFaces) {
        this.dieArray = new Die[numberOfDie];
        for (int i = 0; i < dieArray.length; i++) {
            dieArray[i] = new Die(numberOfFaces);
        }
    }

    /**
     * Create a random number from 1 to 6 for each dice you roll
     * sum all of the random numbers up and that equals total for that roll
     */
    public Integer rollAndSum() {
        Integer sum = 0;
        for (int i = 0; i < dieArray.length; i++) {
            Die die = dieArray[i];
            die.roll();
            sum += die.getCurrentFaceValue();
        }
        return sum;
    }

    /**
     * @return the absolute minimum value that can be rolled by this set of die
     */
    public Integer getRollMin() {
        return dieArray.length;
    }

    /**
     * @return the absolute maximum value that can be rolled by this set of die
     */
    public Integer getRollMax() {
        int maxFaceValue = dieArray[0].getNumberOfFaces();
        return getRollMin() * maxFaceValue;
    }

    @Override
    public Iterator<Die> iterator() {
        return Arrays.asList(dieArray).iterator();
    }
}
