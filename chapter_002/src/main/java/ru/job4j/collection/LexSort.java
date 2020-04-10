package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftNumber = left.split("\\.")[0];
        String rightNumber = right.split("\\.")[0];
        int leftInt = Integer.parseInt(leftNumber);
        int rightInt = Integer.parseInt(rightNumber);
        return Integer.compare(leftInt, rightInt);
    }
}
