package com.github.curriculeon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int smallestRepunitDivByK(int divisor) {
        Integer smallestDivisor = null;
        for(Integer currentValue=divisor; true; currentValue+=divisor) {
            String currentValueAsString = currentValue.toString();
            List<Character> currentValueAsCharList = currentValueAsString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());;
            Set<Character> currentValueAsCharSet = new HashSet<>(currentValueAsCharList);

            int remainder = currentValue % divisor;
            boolean isDivisible = remainder == 0;
            boolean isSizeOne = currentValueAsCharSet.size() == 1;
            boolean containsOne = currentValueAsCharList.contains('1');
            boolean containsAllOnes = isSizeOne && containsOne;
            boolean isApplicable = isDivisible && containsAllOnes;

            if(isApplicable) {
                smallestDivisor = currentValue;
                break;
            }
        }
        return smallestDivisor.toString().length();
    }
}