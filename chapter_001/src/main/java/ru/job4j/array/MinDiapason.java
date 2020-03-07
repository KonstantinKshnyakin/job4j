package ru.job4j.array;

public class MinDiapason {

    public static int findMin(int[] numbers, int start, int finish) {
        int min = numbers[start];
        for (int i = start; i <= finish; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }
}
