package ru.job4j.array;

public class Defragment {

    public static String[] compress(String[] strings) {
        for (int index = 0; index < strings.length; index++) {
            if (strings[index] == null) {
                int point = index;
                while (strings[point] == null && point < strings.length - 1) {
                    point++;
                }
                strings[index] = strings[point];
                strings[point] = null;
            }
            System.out.print(strings[index] + " ");
        }
        return strings;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}
