/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Aunsha Asaithambi
 */
public class Calculator {

    public int add(String numbers) {

        if (numbers == null || numbers.length() == 0) { //edge case
            return 0;
        }
        Set<Character> delemiterSet = getCustomDelimiter(numbers.split("\n")[0]); //get all delimiters

        String[] numberList = numbers.split("\n|" + delemiterSet); //gets all numbers without delimiters

        int sum = 0;
        List<Integer> negativeNumberList = new ArrayList<>();

        for (String s : numberList) {
            if (!s.isEmpty()) { //ignore spaces
                int num = Integer.parseInt(s);
                if(num > 1000){
                    continue;
                }
                if (num >= 0) {
                    sum += num;
                } else {
                    negativeNumberList.add(num); //add negative numbers
                }
            }
        }

        if (!negativeNumberList.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers are not allowed. You entered " + negativeNumberList);
        }
        return sum;
    }

    private Set<Character> getCustomDelimiter(String delimiters) {
        Set<Character> delemiterSet = new HashSet<>();
        if (delimiters.isEmpty()) {
            delemiterSet.add(',');
            return delemiterSet;
        }
        if (delimiters.charAt(0) >= '0' && delimiters.charAt(0) <= '9') { //if does not coontain control code default delimiter is ','
            delemiterSet.add(',');
            return delemiterSet;
        }
        for (int i = 0; i < delimiters.length(); i++) {
            delemiterSet.add(delimiters.charAt(i));
        }
        return delemiterSet;
    }
}
