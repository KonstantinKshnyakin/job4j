package ru.job4j.array;

public class ArrayChar {

    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int i = 0; i < pref.length; i++) {
            boolean isEquals = pref[i] == word[i];
            if (!isEquals) {
                System.out.println(i);
                return false;
            }
        }
        return result;
    }
}
