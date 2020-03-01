package ru.job4j.array;

public class AlgoArray {

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 2, 1, 4};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i]; // переменная для временного хранения значение ячейки с индексом 0.
                    array[i] = array[j]; // записываем в ячейку с индексом 0 значение ячейки с индексом 3.
                    array[j] = temp; // записываем в ячейку с индексом 3 значение временной переменной.
                }
            }
        }

        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }
}
