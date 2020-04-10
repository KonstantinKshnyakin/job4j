package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lim = Math.min(left.length(), right.length());
        for (int i = 0; i < lim; i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            if (leftChar != rightChar) {
                return leftChar - rightChar;
            }
        }
        return left.length() - right.length();
    }
}
