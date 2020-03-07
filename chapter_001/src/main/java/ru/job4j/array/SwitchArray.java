package ru.job4j.array;

public class SwitchArray {

    public static int[] swap(int[] numbers, int source, int dest) {
        int temp = numbers[source];
        numbers[source] = numbers[dest];
        numbers[dest] = temp;
        return numbers;
    }

    public static int[] swapBorder(int[] numbers) {
        int temp = numbers[0];
        numbers[0] = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = temp;
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6};
        int[] rsl = swapBorder(numbers);
        for (int index = 0; index < rsl.length; index++) {
            System.out.println(rsl[index]);
        }
    }
}
